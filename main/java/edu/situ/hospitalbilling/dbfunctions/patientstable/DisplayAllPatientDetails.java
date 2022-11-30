package edu.situ.hospitalbilling.dbfunctions.patientstable;

import edu.situ.hospitalbilling.database.ConnectionProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayAllPatientDetails {
    public static void main(String[] args) throws SQLException {
        Connection connection = new ConnectionProvider().getConnection();
        Statement statement = connection.createStatement();

        String query = "select * from patients";

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()){
            System.out.println("Patient ID: " + resultSet.getString("patient_id"));
            System.out.println("Patient Name: " + resultSet.getString("name"));
            System.out.println("Patient Type: " + resultSet.getString("patient_type"));
            System.out.println("Patient Age: " + resultSet.getInt("age"));
            System.out.println("Patient Sex: " + resultSet.getString("sex"));
            System.out.println("Patient Address: " + resultSet.getString("address_line1") + " " +
                resultSet.getString("address_line2"));
            System.out.println("Pincode: " + resultSet.getInt("pincode"));
            System.out.println("State: " + resultSet.getString("state"));
            System.out.println("Country: " + resultSet.getString("country"));
            System.out.println("Patient Mobile No.: " + resultSet.getString("mobile"));
            System.out.println("Patient Email ID: " + resultSet.getString("email"));
            System.out.println();
            System.out.println();
        }

        connection.close();
    }
}
