# ContactService, TaskService, and AppointmentService

## Project Overview
The `ContactService`, `TaskService`, and `AppointmentService` projects are Java-based applications designed to manage contact, task, and appointment information, respectively, for a mobile application. These services allow adding, updating, and deleting records while enforcing certain constraints on each field. All projects focus on implementing in-memory data structures and unit tests (without a database or user interface). These projects are part of a coursework assignment.

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

## AppointmentService

### Class Structure

#### Appointment Class
The `Appointment` class represents an individual appointment and includes the following attributes:
- **appointmentID**: A unique identifier for the appointment. Must be a non-null string, up to 10 characters, and is immutable once set.
- **appointmentDate**: The date of the appointment. Must be a non-null `Date` object and cannot be in the past.
- **description**: The description of the appointment. Must be a non-null string, up to 50 characters.

#### AppointmentService Class
The `AppointmentService` class manages multiple `Appointment` objects using the following functionality:
- **addAppointment(Appointment appointment)**: Adds an appointment with a unique `appointmentID`.
- **deleteAppointment(String appointmentID)**: Deletes an appointment based on the `appointmentID`.

---

## Project Requirements
These projects require:
- JDK 8 or later
- JUnit 5 for testing

---

## Setup Instructions

1. **Clone or Download the Repository**:
   ```
   git clone https://github.com/AmaroT/CS-Portfolio-Projects.git
   cd CS-Portfolio-Projects
   
---
### How to Ensure Functionality and Security

To ensure functionality, comprehensive unit tests have been developed using JUnit to verify the behavior of all methods in each service. Tests are designed to cover both valid and edge cases, ensuring robustness. For security, the code enforces strict validation for all input fields, preventing invalid or malicious data from being processed or stored.

### Incorporating User Needs into the Program

User needs were interpreted through the functional requirements of managing contacts, tasks, and appointments. Features such as field length constraints, unique identifiers, and descriptive attributes were implemented to align with typical user expectations for mobile applications. Iterative testing and feedback loops ensured that these needs were met effectively.

### Approach to Software Design

The software was designed using object-oriented principles to promote modularity and maintainability. Each class is responsible for a specific type of data, while service classes manage operations on those data objects. This separation of concerns simplifies debugging, testing, and future enhancements. Unit tests were incorporated into the design process to ensure that functionality aligns with specifications from the outset.


