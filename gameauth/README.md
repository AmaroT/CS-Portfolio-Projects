### Gaming Room Application

The Gaming Room Application is an expansion of the game Draw It or Lose It, initially developed for Android. This application demonstrates a prototype that supports multiple operating platforms using a client-server architecture. It is designed to be run in the Eclipse IDE as a Maven project.
### Overview

The goal of this project is to create a simulated environment that demonstrates potential cross-platform deployment options. The application follows a client-server architectural pattern, where the focus is on developing the server-side component using a RESTful API with basic authentication. It features a username and password login interface, along with user protection mechanisms.

### Project Features
- Client-Server Architecture: Implements a REST API to support server-side user management.
- Basic Authentication: Provides basic username and password authentication.
Role-Based Authorization: Restricts access based on user roles.
- User Management: Allows the creation, retrieval, and restriction of user data through a RESTful API.
- API Security: Incorporates authentication and authorization controls to prevent unauthorized access.
### Installation and Setup

### Prerequisites
- Eclipse IDE: This project was created using the Eclipse IDE. To run the project smoothly, it is recommended to use Eclipse.
- Java Development Kit (JDK): Install JDK 8 or higher.
- Maven: Ensure that Maven is installed and properly configured in Eclipse.

### Setup Instructions
1. Import the Project:
     - Download the project zip file.
     - Open Eclipse IDE and go to File > Import > Existing Maven Projects.
     - Select the project folder and ensure the pom.xml file is detected.
       
2. Update Maven Dependencies:
    - Right-click the project in Eclipse and select Maven > Update Project to ensure that all dependencies are properly loaded.
3. Run Configuration:
   - Go to Run > Run Configurations in Eclipse.
   - Select the project under Java Application.
   - Add "server config.yml" as Program Arguments in the Arguments tab.
4. Launch the Application:
   - Click Run to start the server.
   - Open a web browser and visit http://localhost:8080/gameusers to interact with the API.
### Usage Instructions
1. Authentication:
   - The application uses Basic Authentication.
   - Valid usernames include: guest, user, player, admin.
   - The password for all users is password.
2. User Endpoints:
   - GET /gameusers: Returns a list of all game users in JSON format.
   - GET /gameusers/{id}: Returns user details by ID (e.g., http://localhost:8080/gameusers/1).
   - POST /gameusers: Allows creating a new game user (restricted to users with the ADMIN role).
   - Access to each endpoint is restricted based on roles (USER, ADMIN).
3. Example Responses:
   - Successful authentication returns a list of users:
```json

[
  {"id":1,"firstName":"Lokesh","lastName":"Gupta","email":"India"},
  {"id":2,"firstName":"John","lastName":"Gruber","email":"USA"},
  {"id":3,"firstName":"Melcum","lastName":"Marshal","email":"AUS"}
]
```
   - Unauthorized access returns:
  

```json

{"code":403,"message":"User not authorized."}
```
### Technologies Used

  - Java: Primary language for application development.
  - Maven: Build and dependency management.
  - Dropwizard: Used for building RESTful APIs.
  - Basic Authentication: Initial security mechanism for user management.

### Future Enhancements

  - Robust Authentication: Upgrade to a more secure authentication mechanism, such as OAuth2 or JWT.
  - UI Improvements: Implement a more user-friendly interface for better user experience.
  - Additional Features: Add more endpoints to support advanced game functionalities and interactions.

### Industry Standard Best Practices

  - In-line comments and documentation to ensure code readability.
  - Descriptive variable and method naming conventions for maintainability.
  - Secure coding techniques to protect user data and prevent unauthorized access.

### Notes

  - This is an Eclipse project; running it in Eclipse IDE is recommended for ease of development and execution.
  - Make sure to update the Dropwizard version in the pom.xml file if needed to align with the current version.
