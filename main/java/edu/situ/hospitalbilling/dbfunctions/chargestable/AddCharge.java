package edu.situ.hospitalbilling.dbfunctions.chargestable;

import edu.situ.hospitalbilling.database.ConnectionProvider;
import edu.situ.hospitalbilling.model.Charges;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddCharge {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Charges charges = new Charges();

//        System.out.println("Enter the charge type:");
        String chargeType = charges.getChargeType();

//        System.out.println("Enter the charge amount:");
        float chargeAmount = charges.getChargeAmount();

//        scanner.next();

        Connection connection = new ConnectionProvider().getConnection();

        String query = "insert into charges(charge_type, amount) values (?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, chargeType);
        preparedStatement.setFloat(2, chargeAmount);

        preparedStatement.execute();

    }
}
