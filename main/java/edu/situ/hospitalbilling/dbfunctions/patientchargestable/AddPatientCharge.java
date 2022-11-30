package edu.situ.hospitalbilling.dbfunctions.patientchargestable;

import edu.situ.hospitalbilling.database.ConnectionProvider;
import edu.situ.hospitalbilling.model.PatientCharges;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class AddPatientCharge {
    public static void main(String[] args) throws SQLException {
        PatientCharges patientCharges = new PatientCharges();

//        System.out.println("Enter the patient ID:");
        int patientID = patientCharges.getPatientID();

//        System.out.println("Enter the charge ID:");
        int chargeID = patientCharges.getChargeID();

//        System.out.println("Enter the charge amount:");
        float chargeAmount = patientCharges.getAmount();

//        scanner.nextLine();

//        System.out.println("Enter the charge description:");
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

    }
}
