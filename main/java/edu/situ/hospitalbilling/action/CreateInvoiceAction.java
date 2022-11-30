package edu.situ.hospitalbilling.action;

import edu.situ.hospitalbilling.model.*;
import edu.situ.hospitalbilling.service.InvoiceService;
import edu.situ.hospitalbilling.service.PatientService;

import java.sql.SQLException;

public class CreateInvoiceAction {
    private int patientID;
    Invoice invoice = null;

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public String execute() {
        try{
            PatientService patientService = new PatientService();
            invoice = patientService.createInvoice(patientID);
        } catch (Exception e){
            e.printStackTrace();
        }

        return "success";
    }
}
