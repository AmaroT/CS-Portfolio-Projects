// Author: Amaro Terrazas

package com.amaro.contactservice;

public class Contact {
    // Fields
    private final String contactID;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor
    public Contact(String contactID, String firstName, String lastName, String phone, String address) {
        // Validate and assign contactID
        if (contactID == null || contactID.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID. Must not be null and max length 10 characters.");
        }
        this.contactID = contactID;

        // Validate and assign firstName
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name. Must not be null and max length 10 characters.");
        }
        this.firstName = firstName;

        // Validate and assign lastName
        if(lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name. Must not be null and max length 10 characters.");
        }
        this.lastName = lastName;

        // Validate and assign phone
        if(phone == null || phone.length() > 10) {
            throw new IllegalArgumentException("Invalid phone number. Must be exactly 10 digits.");
        }
        this.phone = phone;

        // Validate and assign address
        if(address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address. Must not be null and max length 30 characters.");
        }
        this.address = address;
    }

    // Getters
    public String getContactID() {
        return contactID;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }

    // Setters (only for updatable fields)
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name. Must not be null and max length 10 characters.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name. Must not be null and max length 10 characters.");
        }
        this.lastName = lastName;
    }
    public void setPhone(String phone) {
        if (phone == null || phone.length() > 10) {
            throw new IllegalArgumentException("Invalid phone number. Must not be null and max length 10 characters.");
        }
        this.phone = phone;
    }
    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address. Must not be null and max length 30 characters.");
        }
        this.address = address;
    }
}
