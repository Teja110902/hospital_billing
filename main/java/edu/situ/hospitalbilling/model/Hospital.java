package edu.situ.hospitalbilling.model;

import java.util.Scanner;

public class Hospital {
    private String hospital_name;
    private String address;
    private String pincode;
    private String state;
    private String country;
    private String contact_number;
    private String email_id;
    private String emt_contact_number;

    Scanner scanner = new Scanner(System.in);

    public String getHospital_name() {
        System.out.println("Enter hospital name:");
        hospital_name = scanner.nextLine();

        return hospital_name;
    }

    public String getAddress() {
        System.out.println("Enter hospital address:");
        address = scanner.nextLine();

        return address;
    }

    public String getPincode(){
        System.out.println("Enter pincode:");
        pincode = scanner.nextLine();

        return pincode;
    }

    public String getState(){
        System.out.println("Enter state:");
        state = scanner.nextLine();

        return state;
    }

    public String getCountry(){
        System.out.println("Enter country:");
        country = scanner.nextLine();

        return country;
    }

    public String getContact_number() {
        System.out.println("Enter hospital contact number:");
        contact_number = scanner.nextLine();

        return contact_number;
    }

    public String getEmail_id() {
        System.out.println("Enter hospital Email ID:");
        email_id = scanner.nextLine();

        return email_id;
    }

    public String getEmt_contact_number() {
        System.out.println("Enter EMT Services contact number:");
        emt_contact_number = scanner.nextLine();
        return emt_contact_number;
    }
}