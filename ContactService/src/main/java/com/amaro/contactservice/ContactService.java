// Author: Amaro Terrazas
package com.amaro.contactservice;
import java.util.HashMap;
import java.util.Map;

public class ContactService {
    // In-memory storage for contacts, using contactID as key
    private final Map<String, Contact> contacts;

    // Constructor
    public ContactService() {
        contacts = new HashMap<>();
    }

    // Add a new contact
    public boolean addContact(Contact contact) {
        if (contact == null || contacts.containsKey(contact.getContactID())) {
            return false; // Contact does not exist
        }
        contacts.put(contact.getContactID(), contact);
        return true;
    }

    // Delete a contact by contactID
    public boolean deleteContact(String contactID) {
        if (contactID == null || !contacts.containsKey(contactID)) {
            return false; // contactID does not exist
        }
        contacts.remove(contactID);
        return true;
    }

    // Update contact fields by contactID
    public boolean updateContact(String contactID, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactID);

        if (contact == null) {
            return false; // Contact not found
        }

        // Update only if the values are valid
        if (firstName != null && firstName.length() <= 10) {
            contact.setFirstName(firstName);
        }

        if (lastName != null && lastName.length() <= 10) {
            contact.setLastName(lastName);
        }

        if (phone != null && phone.length() <= 10 && phone.matches("\\d+")) {
            contact.setPhone(phone);
        }
        if (address != null && address.length() <= 30) {
            contact.setAddress(address);
        }
        return true;
    }

    // Get contact by contactID (for testing purposes)
    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}
