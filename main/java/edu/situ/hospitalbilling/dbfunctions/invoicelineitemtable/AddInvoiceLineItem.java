package edu.situ.hospitalbilling.dbfunctions.invoicelineitemtable;

import edu.situ.hospitalbilling.database.ConnectionProvider;
import edu.situ.hospitalbilling.model.InvoiceLineItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddInvoiceLineItem {
    public static void main(String[] args) throws SQLException {
        InvoiceLineItem invoiceLineItem = new InvoiceLineItem();

        int invoiceID = invoiceLineItem.getInvoiceID();
        int chargeID = invoiceLineItem.getChargeID();
        float rate = invoiceLineItem.getRate();
        int qty = invoiceLineItem.getQty();
        float amount = rate * qty;
        String description = invoiceLineItem.getDescription();

        Connection connection = new ConnectionProvider().getConnection();

        String query = "insert into invoice_line_items(invoice_id, charge_id, rate, qty, amount, description) " +
            "values(?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1, invoiceID);
        preparedStatement.setInt(2, chargeID);
        preparedStatement.setFloat(3, rate);
        preparedStatement.setInt(4, qty);
        preparedStatement.setFloat(5, amount);
        preparedStatement.setString(6, description);

        preparedStatement.execute();
    }
}
