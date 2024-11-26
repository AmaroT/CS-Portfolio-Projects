package com.amaro.contactservice;

import java.util.Date;

public class Appointment {
    private final String appointmentID; // Unique appointment ID
    private final Date appointmentDate; // Date of the appointment
    private final String description; // Description of the appointment

    // Constructor
    public Appointment(String appointmentID, Date appointmentDate, String description) {
        // Validate appointmentID
        if (appointmentID == null || appointmentID.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment ID. Must not be null and max 10 characters.");
        }
        this.appointmentID = appointmentID;

        // Validate appointmentDate
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date. Must not be null or in the past.");
        }
        this.appointmentDate = appointmentDate;

        // Validate description
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description. Must not be null and max 50 characters.");
        }
        this.description = description;
    }

    // Getters
    public String getAppointmentID() {
        return appointmentID;
    }
    public Date getAppointmentDate(){
        return appointmentDate;
    }
    public String getDescription() {
        return description;
    }
}
