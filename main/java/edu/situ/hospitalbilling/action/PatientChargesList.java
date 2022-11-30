package edu.situ.hospitalbilling.action;

import edu.situ.hospitalbilling.model.Patient;
import edu.situ.hospitalbilling.model.PatientCharges;
import edu.situ.hospitalbilling.service.PatientService;

import java.sql.SQLException;
import java.util.List;

public class PatientChargesList {
    private List<PatientCharges> patientCharges;
    private int patientID;

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public List<PatientCharges> getPatientCharges() {
        return patientCharges;
    }

    public void setPatientCharges(List<PatientCharges> patientCharges) {
        this.patientCharges = patientCharges;
    }

    public String execute() {
        try{
            PatientService patientService = new PatientService();
            patientCharges = patientService.getPatientCharges(patientID);
        } catch (Exception e){
            e.printStackTrace();
        }

        return "success";
    }
}
