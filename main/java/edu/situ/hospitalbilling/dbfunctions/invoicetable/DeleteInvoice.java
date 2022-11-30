package edu.situ.hospitalbilling.dbfunctions.invoicetable;

import edu.situ.hospitalbilling.database.ConnectionProvider;
import edu.situ.hospitalbilling.model.PatientNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteInvoice {
    public static void main(String[] args) throws PatientNotFoundException {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the invoice ID of the invoice to be deleted:");
            int invoiceID = scanner.nextInt();

            Connection connection = new ConnectionProvider().getConnection();

            String query = "delete from invoices where invoice_id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, invoiceID);

            preparedStatement.executeUpdate();
        } catch (Exception e){
            System.out.println("Exception getting patient details: " + e.getMessage());
            throw new PatientNotFoundException("Cannot find given patient");
        }
    }
}
