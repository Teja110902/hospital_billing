package edu.situ.hospitalbilling.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Invoice {
    private int invoiceID;
    private int patientID;
    private String patientName;
    private LocalDate invoiceDate;
    private String invoiceNumber;
    private String billingStatus;
    private float totalAmount;
    private float paidAmount;
    private float balanceRemaining;
    public ArrayList<InvoiceLineItem> lineItems;

    public Invoice() {
        this.lineItems = new ArrayList<>();
    }

    public Invoice(ResultSet resultSet) throws SQLException {
        this.invoiceID = resultSet.getInt("invoice_id");
        this.patientID = resultSet.getInt("patient_id");
        this.patientName = resultSet.getString("patient_name");
        this.invoiceDate = resultSet.getDate("invoice_date").toLocalDate();
        this.invoiceNumber = resultSet.getString("invoice_number");
        this.billingStatus = resultSet.getString("billing_status");
        this.totalAmount = resultSet.getFloat("total_amount");
        this.paidAmount = resultSet.getFloat("paid_amount");
        this.balanceRemaining = resultSet.getFloat("balanceRemaining");
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getBillingStatus() {
        return billingStatus;
    }

    public void setBillingStatus(String billingStatus) {
        this.billingStatus = billingStatus;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public float getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(float paidAmount) {
        this.paidAmount = paidAmount;
    }

    public float getBalanceRemaining() {
        return balanceRemaining;
    }

    public void setBalanceRemaining(float balanceRemaining) {
        this.balanceRemaining = this.totalAmount - this.paidAmount;
    }

    public void addLineItem(InvoiceLineItem lineItem)   {
        this.lineItems.add(lineItem);
    }

    public void removeLineItem(InvoiceLineItem lineItem){
        this.lineItems.remove(lineItem);
    }

    public ArrayList<InvoiceLineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(ArrayList<InvoiceLineItem> lineItems) {
        this.lineItems = lineItems;
    }
}
