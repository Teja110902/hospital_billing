package edu.situ.hospitalbilling.dbfunctions.chargestable;

import edu.situ.hospitalbilling.database.ConnectionProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayAllChargeDetails {
    public static void main(String[] args) throws SQLException {
        Connection connection = new ConnectionProvider().getConnection();
        Statement statement = connection.createStatement();

        String query = "select * from charges";

        ResultSet resultSet = statement.executeQuery(query);
        System.out.println("************** CHARGE DETAILS **************");
        while (resultSet.next()) {
            System.out.println("Charge ID: " + resultSet.getString("charge_id"));
            System.out.println("Charge Type: " + resultSet.getString("charge_type"));
            System.out.println("Charge Amount: " + resultSet.getFloat("amount"));
            System.out.println();
            System.out.println();
        }
        connection.close();
    }
}