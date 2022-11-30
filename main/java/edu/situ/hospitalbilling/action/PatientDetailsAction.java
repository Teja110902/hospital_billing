package edu.situ.hospitalbilling.action;

import edu.situ.hospitalbilling.model.Patient;
import edu.situ.hospitalbilling.model.PatientCharges;
import edu.situ.hospitalbilling.service.PatientService;

import java.sql.SQLException;
import java.util.List;

public class PatientDetailsAction {
    private int patientID;

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    private Patient patientDetails;
    public Patient getPatientDetails() {
        return patientDetails;
    }

    public void setPatientDetails(Patient patientDetails) {
        this.patientDetails = patientDetails;
    }

    private List<PatientCharges> patientCharges;

    public List<PatientCharges> getPatientCharges() {
        return patientCharges;
    }

    public void setPatientCharges(List<PatientCharges> patientCharges) {
        this.patientCharges = patientCharges;
    }

    public String execute() {
        try{
            PatientService patientService = new PatientService();
            patientDetails = patientService.getPatientDetails(patientID);
            patientCharges = patientService.getPatientCharges(patientID);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "success";
    }
}
