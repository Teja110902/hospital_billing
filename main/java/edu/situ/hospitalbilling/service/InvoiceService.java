package edu.situ.hospitalbilling.service;

import edu.situ.hospitalbilling.database.ConnectionProvider;
import edu.situ.hospitalbilling.model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InvoiceService {
    public Invoice getInvoiceDetails(int invoiceID) throws PatientNotFoundException {
        Invoice invoice = null;
        try {
            Connection connection = new ConnectionProvider().getConnection();
            Statement statement = connection.createStatement();

            String query = "select * from invoices where invoice_id = " + invoiceID;

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                invoice = new Invoice(resultSet);
            }
        } catch (SQLException e) {
            System.out.println("Exception getting patient details: " + e.getMessage());
            throw new PatientNotFoundException("Cannot find given patient");
        }
        return invoice;
    }


}
