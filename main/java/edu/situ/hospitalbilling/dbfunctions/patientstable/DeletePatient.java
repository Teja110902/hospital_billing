package edu.situ.hospitalbilling.dbfunctions.patientstable;

import edu.situ.hospitalbilling.database.ConnectionProvider;
import edu.situ.hospitalbilling.model.PatientNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletePatient {
    public static void main(String[] args) throws PatientNotFoundException {
        try{
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter patient ID to delete:");
            int patientID = scanner.nextInt();

            Connection connection = new ConnectionProvider().getConnection();

            String query = "delete from patients where patient_id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, patientID);

            preparedStatement.execute();
        } catch (Exception e){
            System.out.println("Exception getting patient details: " + e.getMessage());
            throw new PatientNotFoundException("Cannot find given patient");
        }
    }
}
