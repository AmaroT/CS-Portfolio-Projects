package com.amaro.contactservice;

import java.util.HashMap;
import java.util.Map;


public class AppointmentService {
    // In-memory storage for appointments
    private final Map<String, Appointment> appointments;

    // Constructor
    public AppointmentService(){
        appointments = new HashMap<>();
    }

    // Add an appointment
    public boolean addAppointment(Appointment appointment) {
        if (appointment == null || appointments.containsKey(appointment.getAppointmentID())) {
            return false; // Appointment cannot be added
        }
        appointments.put(appointment.getAppointmentID(), appointment);
        return true; // Appointment added successfully
    }

        // Delete an appointment by ID
    public boolean deleteAppointment(String appointmentID) {
        if (appointmentID == null || !appointments.containsKey(appointmentID)) {
            return false; // Appointment cannot be deleted
        }
        appointments.remove(appointmentID);
        return true; //Appointment deleted successfully
    }

    // Get an appointment by ID (for testing purposes)
    public Appointment getAppointment(String appointmentID) {
        return appointments.get(appointmentID);
    }
}
