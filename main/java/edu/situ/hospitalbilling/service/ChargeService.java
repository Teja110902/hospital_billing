package edu.situ.hospitalbilling.service;

import edu.situ.hospitalbilling.database.ConnectionProvider;
import edu.situ.hospitalbilling.model.Charges;
import edu.situ.hospitalbilling.model.PatientNotFoundException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ChargeService {
    public ArrayList<Charges> getCharges() {
        /* DISPLAYS DETAILS OF ALL CHARGES IN GUI */
        Connection connection = null;
        ArrayList<Charges> chargesList = null;
        try {
            connection = new ConnectionProvider().getConnection();
            Statement statement = connection.createStatement();
            String query = "select * from charges";
            chargesList = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(query);
            Charges charge = null;
            while (resultSet.next()) {
                charge = new Charges(resultSet);
                chargesList.add(charge);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return chargesList;
    }

    public Charges getCharge(int chargeID) throws PatientNotFoundException {
        /* DISPLAYS CHARGE DETAILS OF A PARTICULAR PATIENT IN GUI */
        Charges charge = null;
        try {
            Connection connection = new ConnectionProvider().getConnection();
            Statement statement = connection.createStatement();

            String query = "select * from charges where charge_id = " + chargeID;

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                charge = new Charges(resultSet);
            }
        } catch (SQLException e) {
            System.out.println("Exception getting patient details: " + e.getMessage());
            throw new PatientNotFoundException("Cannot find given patient");
        }

        return charge;
    }
}
