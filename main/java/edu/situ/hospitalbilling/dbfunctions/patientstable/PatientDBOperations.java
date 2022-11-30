package edu.situ.hospitalbilling.dbfunctions.patientstable;

import edu.situ.hospitalbilling.database.ConnectionProvider;
import edu.situ.hospitalbilling.model.*;

import java.sql.*;
import java.util.Scanner;

public class PatientDBOperations {
    public void addPatient() throws PatientNotFoundException {
        PreparedStatement preparedStatement = null;
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter patient name:");
            String patientName = scanner.nextLine();

            System.out.println("Enter patient type:");
            String patientType = scanner.nextLine();

            System.out.println("Enter age of patient:");
            int patientAge = scanner.nextInt();

            scanner.nextLine();

            System.out.println("Enter patient sex:");
            String patientSex = scanner.nextLine();

            System.out.println("Enter patient address line 1:");
            String patientAddressLine1 = scanner.nextLine();

            System.out.println("Enter patient address line 2:");
            String patientAddressLine2 = scanner.nextLine();

            System.out.println("Enter pincode:");
            int patientPincode = scanner.nextInt();

            scanner.nextLine();

            System.out.println("Enter state:");
            String state = scanner.nextLine();

            System.out.println("Enter country:");
            String country = scanner.nextLine();

            System.out.println("Enter patient contact number:");
            String patientMobile = scanner.nextLine();

            System.out.println("Enter patient Email ID:");
            String patientEmail = scanner.nextLine();

            Connection connection = new ConnectionProvider().getConnection();

            String query = "insert into patients(name, patient_type, age, sex, address_line1, address_line2, pincode, state, country, mobile, email) " +
                "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, patientName);
            preparedStatement.setString(2, patientType);
            preparedStatement.setInt(3, patientAge);
            preparedStatement.setString(4, patientSex);
            preparedStatement.setString(5, patientAddressLine1);
            preparedStatement.setString(6, patientAddressLine2);
            preparedStatement.setInt(7, patientPincode);
            preparedStatement.setString(8, state);
            preparedStatement.setString(9, country);
            preparedStatement.setString(10, patientMobile);
            preparedStatement.setString(11, patientEmail);

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println("Exception getting patient details: " + e.getMessage());
            throw new PatientNotFoundException("Cannot find given patient");
        }

    }

    public void deletePatient() throws PatientNotFoundException {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter patient ID to delete:");
            int patientID = scanner.nextInt();

            Connection connection = new ConnectionProvider().getConnection();

            String query = "delete from patients where patient_id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, patientID);

            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Exception getting patient details: " + e.getMessage());
            throw new PatientNotFoundException("Cannot find given patient");
        }
    }

    public void displayAllPatientDetails() throws PatientNotFoundException {
        try {
            Connection connection = new ConnectionProvider().getConnection();
            Statement statement = connection.createStatement();

            String query = "select * from patients";

            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("************** PATIENT DETAILS **************");
            while (resultSet.next()) {
                System.out.println("Patient ID: " + resultSet.getInt("patient_id"));
                System.out.println("Patient Name: " + resultSet.getString("name"));
                System.out.println("Patient Type: " + resultSet.getString("patient_type"));
                System.out.println("Patient Age: " + resultSet.getInt("age"));
                System.out.println("Patient Sex: " + resultSet.getString("sex"));
                System.out.println("Patient Address: " + resultSet.getString("address_line1") + " " +
                    resultSet.getString("address_line2"));
                System.out.println("Pincode: " + resultSet.getInt("pincode"));
                System.out.println("State: " + resultSet.getString("state"));
                System.out.println("Country: " + resultSet.getString("country"));
                System.out.println("Patient Mobile No.: " + resultSet.getString("mobile"));
                System.out.println("Patient Email ID: " + resultSet.getString("email"));
                System.out.println();
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Exception getting patient details: " + e.getMessage());
            throw new PatientNotFoundException("Cannot find given patient");
        }
    }
}
