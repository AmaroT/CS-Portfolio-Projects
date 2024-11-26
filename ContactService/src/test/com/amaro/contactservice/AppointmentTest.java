package com.amaro.contactservice;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {
    @Test
    public void testAppointmentCreationSuccess() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000); // Future Date
        Appointment appointment = new Appointment("12345", futureDate, "Doctor's Appointment");
        assertEquals("12345", appointment.getAppointmentID());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Doctor's Appointment", appointment.getDescription());
    }

    @Test
    public void testInvalidAppointmentID() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000); // Future Date
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Doctor's Appointment");
        });
        assertEquals("Invalid appointment ID. Must not be null and max 10 characters.", exception.getMessage());
    }

    @Test
    public void testInvalidAppointmentDate() {
        Date pastDate = new Date(System.currentTimeMillis() - 100000); // Past date
        Exception exception = assertThrows(IllegalArgumentException.class, () ->{
            new Appointment("12345", pastDate, "Doctor's Appointment");
        });
        assertEquals("Invalid appointment date. Must not be null or in the past.", exception.getMessage());
    }

    @Test
    public void testInvalidDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000); // Future Date
        Exception exception = assertThrows(IllegalArgumentException.class, () ->{
            new Appointment("12345", futureDate, null);
        });
        assertEquals("Invalid description. Must not be null and max 50 characters.", exception.getMessage());
    }
}
