// Author: Amaro Terrazas
package com.amaro.contactservice;

import com.amaro.contactservice.Contact;
import com.amaro.contactservice.ContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContactSuccess() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St" );
        assertTrue(contactService.addContact(contact));
        assertEquals(contact, contactService.getContact("12345"));
    }

    @Test
    public void testAddDuplicateContactID() {
        Contact contact1 = new Contact("12345", "John", "Doe", "1234567890", "123 Main St" );
        Contact contact2 = new Contact("12345", "Jane", "Smith", "0987654321", "456 First St" );
        contactService.addContact(contact1);
        assertFalse(contactService.addContact(contact2)); // Should return false for duplicate ID
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St" );
        contactService.addContact(contact);
        assertTrue(contactService.deleteContact("12345"));
        assertNull(contactService.getContact("12345"));
    }

    @Test

    public void testUpdateContactSuccess() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St" );
        contactService.addContact(contact);
        assertTrue(contactService.updateContact("12345", "Jane", "Smith", "0987654321", "456 First St"));

        Contact updatedContact = contactService.getContact("12345");
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("456 First St", updatedContact.getAddress());
    }

    @Test
    public void testUpdateNonexistentContact() {
        assertFalse(contactService.updateContact("99999", "Jane", "Smith", "0987654321", "456 First St"));
    }



<<<<<<< HEAD
}
=======
}
>>>>>>> 459aac8fbc72598a999a07e7ee59cfc1c8b3078a
