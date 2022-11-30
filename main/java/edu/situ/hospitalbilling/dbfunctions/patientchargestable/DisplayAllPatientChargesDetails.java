package edu.situ.hospitalbilling.dbfunctions.patientchargestable;

import edu.situ.hospitalbilling.database.ConnectionProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayAllPatientChargesDetails {
    public static void main(String[] args) throws SQLException {
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
    }
}
