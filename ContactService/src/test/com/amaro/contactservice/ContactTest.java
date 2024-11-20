// Author: Amaro Terrazas
package com.amaro.contactservice;

import com.amaro.contactservice.Contact;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    @Test
    public void testContactCreationSuccess() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("12345", contact.getContactID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testInvalidContactID() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
        assertEquals("Invalid contact ID. Must not be null and max length 10 characters.", exception.getMessage());
    }
    @Test
    public void testInvalidFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Doe", "1234567890", "123 Main St");
        });
        assertEquals("Invalid first name. Must not be null and max length 10 characters.", exception.getMessage());
    }
    @Test
    public void testInvalidLastName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", null, "1234567890", "123 Main St");
        });
        assertEquals("Invalid last name. Must not be null and max length 10 characters.", exception.getMessage());
    }
    @Test
    public void testInvalidPhone() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", null, "123 Main St");
        });
        assertEquals("Invalid phone number. Must be exactly 10 digits.", exception.getMessage());
    }
    @Test
    public void testInvalidAddress() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "1234567890", null);
        });
        assertEquals("Invalid address. Must not be null and max length 30 characters.", exception.getMessage());
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 459aac8fbc72598a999a07e7ee59cfc1c8b3078a
