package edu.situ.hospitalbilling.dbfunctions.hospitaltable;

import edu.situ.hospitalbilling.database.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteHospital {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the hospital to delete:");
        String hospitalName = scanner.nextLine();

        Connection connection = new ConnectionProvider().getConnection();

        String query = "delete from hospital where name = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, hospitalName);

        preparedStatement.execute();
    }
}
