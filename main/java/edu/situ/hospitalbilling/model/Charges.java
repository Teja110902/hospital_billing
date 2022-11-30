package edu.situ.hospitalbilling.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Charges {
    private int chargeID;
    private String chargeType;
    private float chargeAmount;

    public Charges(ResultSet resultSet) throws SQLException {
        chargeID = resultSet.getInt("charge_id");
        this.chargeType = resultSet.getString("charge_type");
        this.chargeAmount = resultSet.getFloat("amount");
    }

    public Charges() {

    }

    public int getChargeID() {
        return chargeID;
    }

    public void setChargeID(int chargeID) {
        this.chargeID = chargeID;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public float getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(float chargeAmount) {
        this.chargeAmount = chargeAmount;
    }
}
