package edu.situ.hospitalbilling.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OutPatient extends AbstractPatient {

    public OutPatient(ResultSet resultSet) throws SQLException {
        super(resultSet);
    }

    @Override
    public List<PatientCharges> getCharges() {
        return null;
    }
}
