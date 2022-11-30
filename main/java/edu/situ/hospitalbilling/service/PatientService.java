package edu.situ.hospitalbilling.service;

import edu.situ.hospitalbilling.database.ConnectionProvider;
import edu.situ.hospitalbilling.form.PatientChargeForm;
import edu.situ.hospitalbilling.model.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientService {
    /* DISPLAYS DETAILS OF ALL PATIENTS IN GUI */
    public List<Patient> getPatientList() {
        List<Patient> patients = null;
        try {
            Connection connection = new ConnectionProvider().getConnection();
            Statement statement = connection.createStatement();

            String query = "select * from patients";

            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("************** PATIENT DETAILS **************");
            InPatient inPatient = null;
            OutPatient outPatient = null;
            Patient patient = null;

            patients = new ArrayList<>(10);

            while (resultSet.next()) {
                String patientType = resultSet.getString("patient_type");
                if (patientType.equals("Inpatient")) {
                    patient = new InPatient(resultSet);
                } else {
                    patient = new OutPatient(resultSet);
                }
                patients.add(patient);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }

    /* DISPLAYS DETAILS OF A PARTICULAR PATIENT IN GUI */
    public Patient getPatientDetails(int patientID) throws PatientNotFoundException{
        Patient patient = null;
        try {
            Connection connection = new ConnectionProvider().getConnection();
            Statement statement = connection.createStatement();

            String query = "select * from patients where patient_id = " + patientID;

            ResultSet resultSet = statement.executeQuery(query);

            InPatient inPatient = null;
            OutPatient outPatient = null;

            while (resultSet.next()) {
                String patientType = resultSet.getString("patient_type");
                if (patientType.equals("Inpatient")) {
                    patient = new InPatient(resultSet);
                } else {
                    patient = new OutPatient(resultSet);
                }
            }
//        System.out.println("The patient details are " + patient.getPatientName());
        } catch (SQLException e) {
            System.out.println("Exception getting patient details: " + e.getMessage());
            throw new PatientNotFoundException("Cannot find the given patient");
        }
        return patient;
    }

    public List<PatientCharges> getPatientCharges(int patientID) {
        List<PatientCharges> listOfPatientCharges = null;
        try {
            Connection connection = new ConnectionProvider().getConnection();
            Statement statement = connection.createStatement();

            PatientCharges patientCharges = null;

            String query = "select * from patient_charges where patient_id = " + patientID;
            listOfPatientCharges = new ArrayList<>(10);

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                patientCharges = new PatientCharges(resultSet);
                listOfPatientCharges.add(patientCharges);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfPatientCharges;
    }

    public Invoice createInvoice(int patientID) throws PatientNotFoundException{
        Invoice invoice = null;
        try {
            invoice = new Invoice();
            Patient patient = null;
            float chargeAmount = 0.0f;

            //TODO get patient details using patient id
            patient = getPatientDetails(patientID);

            //TODO get patient charges using patient ID
            List<PatientCharges> charges = getPatientCharges(patientID);
            invoice.setPatientName(patient.getPatientName());
            invoice.setInvoiceDate(LocalDate.now());
            invoice.setBillingStatus("Pending");

            invoice.setPaidAmount(0.0f);
            String invoiceNumber = String.valueOf(System.currentTimeMillis());
            invoice.setInvoiceNumber(invoiceNumber);

            Connection connection = new ConnectionProvider().getConnection();
            String query = "insert into invoices(patient_id, patient_name, invoice_date, billing_status, invoice_number, " +
                "total_amount, paid_amount, balance_remaining) values(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, patientID);
            preparedStatement.setString(2, patient.getPatientName());
            preparedStatement.setDate(3, Date.valueOf(invoice.getInvoiceDate()));
            preparedStatement.setString(4, invoice.getBillingStatus());
            preparedStatement.setString(5, invoiceNumber);
            preparedStatement.setFloat(6, invoice.getTotalAmount());
            preparedStatement.setFloat(7, invoice.getPaidAmount());
            preparedStatement.setFloat(8, invoice.getBalanceRemaining());

            int rowsAffected = preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            int invoiceID = -1;

            if (resultSet.next()) {
                invoiceID = resultSet.getInt(1);
            }

            System.out.println("The invoice ID is " + invoiceID);
            invoice.setInvoiceID(invoiceID);

            InvoiceLineItem lineItem = null;

            String lineItemQuery = "insert into invoice_line_items(invoice_id, charge_id, rate, qty, amount, description) " +
                "values (?, ?, ?, ?, ?, ?)";

            for (PatientCharges charge : charges) {
                PreparedStatement lineItemPreparedStatement = connection.prepareStatement(lineItemQuery);

                lineItemPreparedStatement.setInt(1, invoiceID);
                lineItemPreparedStatement.setInt(2, charge.getChargeID());
                lineItemPreparedStatement.setFloat(3, charge.getAmount());
                lineItemPreparedStatement.setInt(4, 1); // Qty
                lineItemPreparedStatement.setFloat(5, ((charge.getAmount() * 1)));
                lineItemPreparedStatement.setString(6, charge.getDescription());

                int lineItemRowsAffected = lineItemPreparedStatement.executeUpdate();

                lineItem = new InvoiceLineItem();
                lineItem.setInvoiceID(invoice.getInvoiceID());
                lineItem.setChargeID(charge.getChargeID());
                lineItem.setRate(charge.getAmount());
                lineItem.setQty(1);
                lineItem.setDescription(charge.getDescription());

                chargeAmount += charge.getAmount();

                invoice.addLineItem(lineItem);
            }
            invoice.setTotalAmount(chargeAmount);

            String updateTotalQuery = "update invoices set total_amount = " + chargeAmount + " where invoice_id = " + invoiceID;
            PreparedStatement updatePreparedStatement = connection.prepareStatement(updateTotalQuery);
            updatePreparedStatement.execute();

        } catch (SQLException e) {
            System.out.println("Exception getting patient details: " + e.getMessage());
            throw new PatientNotFoundException("Cannot find given patient");
        }
        return invoice;
    }

    public void savePatientCharge(PatientChargeForm chargeForm) throws PatientNotFoundException{
        try{
            ChargeService chargeService = new ChargeService();
            Charges charge = chargeService.getCharge(chargeForm.getChargeID());

            Connection connection = new ConnectionProvider().getConnection();

            String savePatientChargeQuery = "insert into patient_charges(patient_id, charge_id, amount, description, charge_date)" +
                "values(?, ?, ?, ?, ?)";

            PreparedStatement savePatientChargePreparedStatement = connection.prepareStatement(savePatientChargeQuery);
            System.out.println("---------------");
            System.out.println(chargeForm.getPatientID() + " " + chargeForm.getChargeID() + " " + chargeForm.getChargeDate());

            savePatientChargePreparedStatement.setInt(1, chargeForm.getPatientID());
            savePatientChargePreparedStatement.setInt(2, charge.getChargeID());
            savePatientChargePreparedStatement.setFloat(3, charge.getChargeAmount());
            savePatientChargePreparedStatement.setString(4, charge.getChargeType());
            savePatientChargePreparedStatement.setDate(5, new java.sql.Date(chargeForm.getChargeDate().getTime()));

            savePatientChargePreparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Exception getting patient details: " + e.getMessage());
            throw new PatientNotFoundException("Cannot find given patient");
        }
    }
}
