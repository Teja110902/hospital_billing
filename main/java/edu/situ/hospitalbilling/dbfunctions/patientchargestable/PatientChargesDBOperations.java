package edu.situ.hospitalbilling.dbfunctions.patientchargestable;

import edu.situ.hospitalbilling.database.ConnectionProvider;
import edu.situ.hospitalbilling.model.PatientCharges;
import edu.situ.hospitalbilling.database.ConnectionProvider;
import edu.situ.hospitalbilling.model.PatientCharges;
import edu.situ.hospitalbilling.model.PatientNotFoundException;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class PatientChargesDBOperations {
    public void addPatientCharge() throws PatientNotFoundException {
        try{
            PatientCharges patientCharges = new PatientCharges();

            int patientID = patientCharges.getPatientID();
            int chargeID = patientCharges.getChargeID();
            float chargeAmount = patientCharges.getAmount();
            String chargeDesc = patientCharges.getDescription();
            LocalDate chargeDate = patientCharges.getChargeDate();

            Connection connection = new ConnectionProvider().getConnection();

            String query = "insert into patient_charges(patient_id, charge_id, amount, description, charge_date) " +
                "values(?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, patientID);
            preparedStatement.setInt(2, chargeID);
            preparedStatement.setFloat(3, chargeAmount);
            preparedStatement.setString(4, chargeDesc);
            preparedStatement.setDate(5, Date.valueOf(chargeDate));

            preparedStatement.execute();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Exception getting patient details: " + e.getMessage());
            throw new PatientNotFoundException("Cannot find given patient");
        }
    }

    public void deletePatientCharge() throws PatientNotFoundException {
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.println("Enter the patient charge ID to delete:");
            int patientChargeID = scanner.nextInt();

            Connection connection = new ConnectionProvider().getConnection();

            String query = "delete from patient_charges where patient_charge_id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, patientChargeID);

            preparedStatement.execute();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Exception getting patient details: " + e.getMessage());
            throw new PatientNotFoundException("Cannot find given patient");
        }
    }

    public void displayAllPatientChargesDetails() throws PatientNotFoundException {
        try{
            Connection connection = new ConnectionProvider().getConnection();
            Statement statement = connection.createStatement();

            String query = "select * from patient_charges";

            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("************** PATIENT CHARGES DETAILS **************");
            while (resultSet.next()){
                System.out.println("Patient Charge ID: " + resultSet.getInt("patient_charge_id"));
                System.out.println("Patient ID: " + resultSet.getInt("patient_id"));
                System.out.println("Charge ID: " + resultSet.getInt("charge_id"));
                System.out.println("Charge Amount: " + resultSet.getFloat("amount"));
                System.out.println("Description: " + resultSet.getString("description"));
                System.out.println("Charge Date: " + resultSet.getString("charge_date"));

                System.out.println();
                System.out.println();
            }

            connection.close();
        } catch (SQLException e){
            System.out.println("Exception getting patient details: " + e.getMessage());
            throw new PatientNotFoundException("Cannot find given patient");
        }
    }
}
