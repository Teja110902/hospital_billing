package edu.situ.hospitalbilling.dbfunctions.chargestable;

import edu.situ.hospitalbilling.database.ConnectionProvider;
import edu.situ.hospitalbilling.model.Charges;

import java.sql.*;
import java.util.Scanner;

public class ChargesDBOperations {
    public void addCharge() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Charges charges = new Charges();

        String chargeType = charges.getChargeType();

        float chargeAmount = charges.getChargeAmount();

        Connection connection = new ConnectionProvider().getConnection();

        String query = "insert into charges(charge_type, amount) values (?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, chargeType);
        preparedStatement.setFloat(2, chargeAmount);

        preparedStatement.execute();
    }

    public void deleteCharge() throws SQLException {
        Charges charges = new Charges();
        Scanner scanner = new Scanner(System.in);

        int chargeID = charges.getChargeID();

        Connection connection = new ConnectionProvider().getConnection();

        String query = "delete from charges where charge_id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, chargeID);

        preparedStatement.execute();
    }

    public void displayAllChargeDetails() throws SQLException {
        Connection connection = new ConnectionProvider().getConnection();
        Statement statement = connection.createStatement();

        String query = "select * from charges";

        ResultSet resultSet = statement.executeQuery(query);

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
