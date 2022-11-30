package edu.situ.hospitalbilling.action;

import edu.situ.hospitalbilling.form.PatientChargeForm;
import edu.situ.hospitalbilling.service.PatientService;

import java.sql.SQLException;

public class SavePatientCharge {
    private PatientChargeForm chargeForm;

    public PatientChargeForm getChargeForm() {
        return chargeForm;
    }

    public void setChargeForm(PatientChargeForm chargeForm) {
        this.chargeForm = chargeForm;
    }

    public String execute() {
        try {
            PatientService patientService = new PatientService();
            patientService.savePatientCharge(chargeForm);

        } catch (Exception e){
            e.printStackTrace();
        }

        return "success";
    }
}
