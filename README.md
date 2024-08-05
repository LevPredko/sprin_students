Student Management System

 Overview

The Student Management System is a comprehensive web application designed to manage student records efficiently. The application provides an interface for adding, editing, deleting, and searching student records using Thymeleaf templates. It is integrated with a PostgreSQL database for data persistence and leverages Spring Security for robust authentication mechanisms.

 Features

- Student Management: 
  - Add new student records
  - Edit existing student details
  - Delete student records
  - Search for students by various criteria

- Authentication: 
  - Secure login and access control using Spring Security
  - Role-based access for different user types (e.g., lecturers)

- Database Integration: 
  - PostgreSQL database for storing student information

- Advanced Functionality:
  - A shared table for exam submissions, linking students with their respective lecturers

 Technologies Used

- Spring Boot: For creating the application and handling backend services.
- Thymeleaf: For rendering HTML templates and providing a dynamic web interface.
- Spring Security: For authentication and authorization.
- PostgreSQL: For database management and data storage.

 Getting Started

 Prerequisites

- JDK 17 or later
- PostgreSQL Database
- Maven
- IDE like IntelliJ IDEA

Installation

1. Clone the Repository:

   ```bash
   git clone https://github.com/LevPredko/spring_students.git
   ```

2. Set Up the Database:**

   Ensure PostgreSQL is installed and create a new database for the application. Update the `application.properties` file with your database credentials.

3. Build and Run the Application:

   Navigate to the project directory and use Maven to build and run the application:

   ```bash
   cd spring_students
   mvn clean install
   mvn spring-boot:run
   ```

4. Access the Application:

   Open a web browser and go to `http://localhost:8080` to access the application.

 Configuration

- **Database Configuration**: Update `src/main/resources/application.yaml` with your PostgreSQL database details.
- **Security Configuration**: Customize `src/main/java/predko/ua/springstudents/security/SecurityConfig.java` for authentication and authorization settings.

 Contributing
Contributions are welcome! Please submit a pull request with your changes or enhancements.

 License
This project is licensed under the MIT License.
