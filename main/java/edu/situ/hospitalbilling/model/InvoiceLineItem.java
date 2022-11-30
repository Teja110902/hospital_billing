package edu.situ.hospitalbilling.model;

import java.util.Scanner;

public class InvoiceLineItem {
    private int invoiceLineItemID;
    private int invoiceID;
    private int chargeID;
    private float rate;
    private int qty;
    private String description;

    public int getInvoiceLineItemID() {
        return invoiceLineItemID;
    }

    public void setInvoiceLineItemID(int invoiceLineItemID) {
        this.invoiceLineItemID = invoiceLineItemID;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public int getChargeID() {
        return chargeID;
    }

    public void setChargeID(int chargeID) {
        this.chargeID = chargeID;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getTotalAmount(){
        return this.rate * this.qty;
    }
}
