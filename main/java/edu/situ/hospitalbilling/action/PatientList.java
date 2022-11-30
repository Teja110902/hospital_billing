package edu.situ.hospitalbilling.action;

import edu.situ.hospitalbilling.database.ConnectionProvider;
import edu.situ.hospitalbilling.model.Patient;
import edu.situ.hospitalbilling.service.PatientService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PatientList {

    private List<Patient> patientList;

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public String execute() {
        try{
            PatientService patientService = new PatientService();
            patientList = patientService.getPatientList();
        } catch (Exception e){
            e.printStackTrace();
        }

        return "success";
    }
}
