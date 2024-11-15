# ContactService

## Project Overview
The `ContactService` project is a Java-based application designed to manage contact information for a mobile application. This service allows adding, updating, and deleting contacts while enforcing certain constraints on each contact’s fields. This project is part of a coursework assignment and focuses on implementing in-memory data structures and unit tests (without a database or user interface).

## Class Structure

### Contact Class
The `Contact` class represents an individual contact and includes the following attributes:
- **contactID**: A unique identifier for the contact. Must be a non-null string, up to 10 characters, and is immutable once set.
- **firstName**: The first name of the contact. Must be a non-null string, up to 10 characters.
- **lastName**: The last name of the contact. Must be a non-null string, up to 10 characters.
- **phone**: The contact's phone number. Must be exactly 10 digits and non-null.
- **address**: The contact’s address. Must be a non-null string, up to 30 characters.

### ContactService Class
The `ContactService` class manages multiple `Contact` objects using the following functionality:
- **addContact(Contact contact)**: Adds a contact with a unique `contactID`.
- **deleteContact(String contactID)**: Deletes a contact based on the `contactID`.
- **updateContact(String contactID, String firstName, String lastName, String phone, String address)**: Updates specified fields of an existing contact by `contactID`.

## Project Requirements
This project requires:
- JDK 8 or later
- JUnit 5 for testing

## Setup Instructions
1. **Clone or Download the Repository**:
   ```bash
   git clone https://github.com/AmaroT/ContactService.git
   cd ContactService
