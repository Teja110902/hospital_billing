package edu.situ.hospitalbilling.dbfunctions.invoicetable;

import edu.situ.hospitalbilling.database.ConnectionProvider;
import edu.situ.hospitalbilling.model.Invoice;
import edu.situ.hospitalbilling.model.PatientNotFoundException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class AddInvoice {
    public static void main(String[] args) throws PatientNotFoundException {
        try{
            Invoice invoice = new Invoice();

            int patientID = invoice.getPatientID();
            String patientName = invoice.getPatientName();
            LocalDate invoiceDate = invoice.getInvoiceDate();
            String billingStatus = invoice.getBillingStatus();
            int invoiceNumber = Integer.parseInt(invoice.getInvoiceNumber());
            float totalAmount = invoice.getTotalAmount();
            float paidAmount = invoice.getPaidAmount();
            float balanceRemaining = invoice.getBalanceRemaining();

            Connection connection = new ConnectionProvider().getConnection();

            String query = "insert into invoices(patient_id, patient_name, invoice_date, " +
                "billing_status, invoice_number, total_amount, paid_amount, balance_remaining)" +
                "values(?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, patientID);
            preparedStatement.setString(2, patientName);
            preparedStatement.setDate(3, Date.valueOf(invoiceDate));
            preparedStatement.setString(4, billingStatus);
            preparedStatement.setInt(5, invoiceNumber);
            preparedStatement.setFloat(6, totalAmount);
            preparedStatement.setFloat(7, paidAmount);
            preparedStatement.setFloat(8, balanceRemaining);

            preparedStatement.executeUpdate();
        } catch (Exception e){
            System.out.println("Exception getting patient details: " + e.getMessage());
            throw new PatientNotFoundException("Cannot find given patient");
        }
    }
}
