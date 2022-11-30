package edu.situ.hospitalbilling.dbfunctions.chargestable;

import edu.situ.hospitalbilling.database.ConnectionProvider;
import edu.situ.hospitalbilling.model.Charges;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteCharge {
    public static void main(String[] args) throws SQLException {
        Charges charges = new Charges();
        Scanner scanner = new Scanner(System.in);

//        System.out.println("Enter the charge ID to delete:");
        int chargeID = charges.getChargeID();

        Connection connection = new ConnectionProvider().getConnection();

        String query = "delete from charges where charge_id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, chargeID);

        preparedStatement.execute();
    }
}
