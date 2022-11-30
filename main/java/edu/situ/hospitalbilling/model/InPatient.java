package edu.situ.hospitalbilling.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class InPatient extends AbstractPatient {

    public InPatient(ResultSet resultSet) throws SQLException {
        super(resultSet);
    }

    @Override
    public List<PatientCharges> getCharges() {
        return null;
    }
}
