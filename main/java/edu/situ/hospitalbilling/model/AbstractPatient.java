package edu.situ.hospitalbilling.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public abstract class AbstractPatient implements Patient {
    protected int patientID;
    protected String patientName;
    protected String patientType = "Inpatient";
    protected String patientSex;
    protected int patientAge;
    protected String patientAddressLine1;
    protected String patientAddressLine2;
    protected String patientState;
    protected int patientPincode;
    protected String patientCountry;
    protected String PatientContactNo;
    protected String patientEmailID;
    Scanner scanner = new Scanner(System.in);
    private String patientRoomType;
    private String doctorConsulted;

    public AbstractPatient(ResultSet resultSet) throws SQLException {
        this.patientID = resultSet.getInt("patient_id");
        this.patientName = resultSet.getString("name");
        this.patientType = resultSet.getString("patient_type");
        this.patientSex = resultSet.getString("sex");
        this.patientAge = resultSet.getInt("age");
        this.patientAddressLine1 = resultSet.getString("address_line1");
        this.patientAddressLine2 = resultSet.getString("address_line2");
        this.patientState = resultSet.getString("state");
        this.patientPincode = resultSet.getInt("pincode");
        this.patientCountry = resultSet.getString("country");
        this.PatientContactNo = resultSet.getString("mobile");
        this.patientEmailID = resultSet.getString("email");
    }

    @Override
    public int getPatientID() {
        return patientID;
    }

    @Override
    public String getPatientName() {
        return patientName;
    }

    @Override
    public String getPatientType() {
        return patientType;
    }

    @Override
    public String getPatientSex() {
        return patientSex;
    }

    @Override
    public int getPatientAge() {
        return patientAge;
    }

    @Override
    public String getPatientAddressLine1() {
        return patientAddressLine1;
    }

    @Override
    public String getPatientAddressLine2() {
        return patientAddressLine2;
    }

    @Override
    public String getPatientState() {
        return patientState;
    }

    @Override
    public int getPatientPincode() {
        return patientPincode;
    }

    @Override
    public String getPatientCountry() {
        return patientCountry;
    }

    public String getPatientContactNo() {
        return PatientContactNo;
    }

    @Override
    public String getPatientEmailID() {
        return patientEmailID;
    }


//    public String getPatientRoomType() {
//        return patientRoomType;
//    }

    @Override
    public String getDoctorConsulted() {
        return doctorConsulted;
    }
}
