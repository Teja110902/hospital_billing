package edu.situ.hospitalbilling.dbfunctions.patientstable;

import edu.situ.hospitalbilling.database.ConnectionProvider;
import edu.situ.hospitalbilling.model.PatientNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddPatient {
    public static void main(String[] args) throws PatientNotFoundException {
        try{
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

            PreparedStatement preparedStatement = connection.prepareStatement(query);

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
        } catch (Exception e){
            System.out.println("Exception getting patient details: " + e.getMessage());
            throw new PatientNotFoundException("Cannot find given patient");
        }
    }
}
