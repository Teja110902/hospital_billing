package edu.situ.hospitalbilling.dbfunctions.hospitaltable;

import edu.situ.hospitalbilling.database.ConnectionProvider;
import edu.situ.hospitalbilling.model.Hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddHospital {
    public static void main(String[] args) throws SQLException {
        Hospital hospital = new Hospital();

        String hospitalName = hospital.getHospital_name();
        String address = hospital.getAddress();
        String pincode = hospital.getPincode();
        String state = hospital.getState();
        String country = hospital.getCountry();
        String contactNumber = hospital.getContact_number();
        String emailID = hospital.getEmail_id();
        String emtServicesContactNumber = hospital.getEmt_contact_number();

        Connection connection = new ConnectionProvider().getConnection();

        String query = "insert into hospital(name, address, pincode, state, country, contact_No," +
            "email, emt_services_contact) values(?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, hospitalName);
        preparedStatement.setString(2, address);
        preparedStatement.setString(3, pincode);
        preparedStatement.setString(4, state);
        preparedStatement.setString(5, country);
        preparedStatement.setString(6, contactNumber);
        preparedStatement.setString(7, emailID);
        preparedStatement.setString(8, emtServicesContactNumber);

        preparedStatement.execute();

    }
}
