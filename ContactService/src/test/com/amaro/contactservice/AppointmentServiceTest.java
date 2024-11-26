package com.amaro.contactservice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentServiceTest {

    private AppointmentService appointmentService;

    @BeforeEach
    public void setUp() {
        appointmentService = new AppointmentService();
    }

    @Test
    public void testAddAppointmentSuccess() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000); // Future Date
        Appointment appointment = new Appointment("12345", futureDate, "Dentist appointment");
        assertTrue(appointmentService.addAppointment(appointment));
        assertEquals(appointment, appointmentService.getAppointment("12345"));
    }

    @Test
    public void testAddDuplicateAppointmentID() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000); // Future Date
        Appointment appointment1 = new Appointment("12345", futureDate, "Dentist appointment");
        Appointment appointment2 = new Appointment("12345", futureDate, "Doctor's appointment");
        appointmentService.addAppointment(appointment1);
        assertFalse(appointmentService.addAppointment(appointment2)); // Duplicate ID should fail
    }

    @Test
    public void testDeleteAppointmentSuccess() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000); // Future Date
        Appointment appointment = new Appointment("12345", futureDate, "Dentist appointment");
        appointmentService.addAppointment(appointment);
        assertTrue(appointmentService.deleteAppointment("12345"));
        assertNull(appointmentService.getAppointment("12345"));
    }

    @Test
    public void testDeleteDuplicateAppointment() {
        assertFalse(appointmentService.deleteAppointment("999999")); // Non-existent Appointment ID
    }
}

