package edu.situ.hospitalbilling.dbfunctions.invoicelineitemtable;

import edu.situ.hospitalbilling.database.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteInvoiceLineItem {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the line item ID of the item to delete:");
        int lineItemID = scanner.nextInt();

        Connection connection = new ConnectionProvider().getConnection();

        String query = "delete from invoice_line_items where line_item_id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1, lineItemID);

        preparedStatement.execute();
    }
}
