package edu.situ.hospitalbilling.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class PatientCharges {
    private int patientChargeID;
    private int patientID;
    private int chargeID;
    private float amount;
    private String description;
    private LocalDate chargeDate;

    public PatientCharges(ResultSet resultSet) throws SQLException {
        this.patientChargeID = resultSet.getInt("patient_charge_id");
        this.patientID = resultSet.getInt("patient_id");
        this.chargeID = resultSet.getInt("charge_id");
        this.amount = resultSet.getFloat("amount");
        this.description = resultSet.getString("description");
        this.chargeDate = resultSet.getDate("charge_date").toLocalDate();
    }

    public PatientCharges() {

    }

    public int getPatientChargeID() {
        return patientChargeID;
    }

    public void setPatientChargeID(int patientChargeID) {
        this.patientChargeID = patientChargeID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getChargeID() {
        return chargeID;
    }

    public void setChargeID(int chargeID) {
        this.chargeID = chargeID;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(LocalDate chargeDate) {
        this.chargeDate = chargeDate;
    }
}
