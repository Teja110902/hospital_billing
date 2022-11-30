package edu.situ.hospitalbilling.model;

public class PatientNotFoundException extends Exception{
    public PatientNotFoundException(String msg) {
        super(msg);
    }
}
