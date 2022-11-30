package edu.situ.hospitalbilling.dbfunctions.patientchargestable;

import edu.situ.hospitalbilling.database.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletePatientCharge {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the patient charge ID to delete:");
        int patientChargeID = scanner.nextInt();

        Connection connection = new ConnectionProvider().getConnection();

        String query = "delete from patient_charges where patient_charge_id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, patientChargeID);

        preparedStatement.execute();
    }
}
