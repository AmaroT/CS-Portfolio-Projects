# ContactService and TaskService

## Project Overview
The `ContactService` and `TaskService` projects are Java-based applications designed to manage contact and task information, respectively, for a mobile application. These services allow adding, updating, and deleting records while enforcing certain constraints on each field. Both projects focus on implementing in-memory data structures and unit tests (without a database or user interface). These projects are part of a coursework assignment.

---

## ContactService

### Class Structure

#### Contact Class
The `Contact` class represents an individual contact and includes the following attributes:
- **contactID**: A unique identifier for the contact. Must be a non-null string, up to 10 characters, and is immutable once set.
- **firstName**: The first name of the contact. Must be a non-null string, up to 10 characters.
- **lastName**: The last name of the contact. Must be a non-null string, up to 10 characters.
- **phone**: The contact's phone number. Must be exactly 10 digits and non-null.
- **address**: The contact’s address. Must be a non-null string, up to 30 characters.

#### ContactService Class
The `ContactService` class manages multiple `Contact` objects using the following functionality:
- **addContact(Contact contact)**: Adds a contact with a unique `contactID`.
- **deleteContact(String contactID)**: Deletes a contact based on the `contactID`.
- **updateContact(String contactID, String firstName, String lastName, String phone, String address)**: Updates specified fields of an existing contact by `contactID`.

---

## TaskService

### Class Structure

#### Task Class
The `Task` class represents an individual task and includes the following attributes:
- **taskID**: A unique identifier for the task. Must be a non-null string, up to 10 characters, and is immutable once set.
- **name**: The name of the task. Must be a non-null string, up to 20 characters.
- **description**: The description of the task. Must be a non-null string, up to 50 characters.

#### TaskService Class
The `TaskService` class manages multiple `Task` objects using the following functionality:
- **addTask(Task task)**: Adds a task with a unique `taskID`.
- **deleteTask(String taskID)**: Deletes a task based on the `taskID`.
- **updateTask(String taskID, String name, String description)**: Updates specified fields of an existing task by `taskID`.

---

## Project Requirements
These projects require:
- JDK 8 or later
- JUnit 5 for testing

---

## Setup Instructions

1. **Clone or Download the Repository**:
   ```bash
   git clone https://github.com/AmaroT/ContactService.git
   cd ContactService
