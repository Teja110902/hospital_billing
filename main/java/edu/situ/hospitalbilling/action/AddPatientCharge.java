package edu.situ.hospitalbilling.action;

import edu.situ.hospitalbilling.form.PatientChargeForm;
import edu.situ.hospitalbilling.model.Charges;
import edu.situ.hospitalbilling.model.PatientCharges;
import edu.situ.hospitalbilling.service.ChargeService;

import java.sql.SQLException;
import java.util.ArrayList;

public class AddPatientCharge {
    private int patientID;
    private PatientChargeForm chargeForm;

    private ArrayList<Charges> charges;

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public PatientChargeForm getChargeForm() {
        return chargeForm;
    }

    public void setChargeForm(PatientChargeForm chargeForm) {
        this.chargeForm = chargeForm;
    }

    public ArrayList<Charges> getCharges() {
        return charges;
    }

    public void setCharges(ArrayList<Charges> charges) {
        this.charges = charges;
    }

    public String execute() {
        try {
            ChargeService chargeService = new ChargeService();
            this.charges = chargeService.getCharges();
        } catch (Exception e){
            e.printStackTrace();
        }

        return "success";
    }

}
