package edu.situ.hospitalbilling.model;

import java.util.List;

public interface Patient {
    int getPatientID();
    String getPatientName();
    String getPatientType();
    String getPatientSex();
    int getPatientAge();
    String getPatientAddressLine1();
    String getPatientAddressLine2();
    String getPatientState();
    int getPatientPincode();
    String getPatientCountry();
    String getPatientContactNo();
    String getPatientEmailID();
    String getDoctorConsulted();
    public List<PatientCharges> getCharges();
}
