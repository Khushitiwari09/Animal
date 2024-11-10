#Animal Adoption and Caretaking Management System
Overview
This project is a simple Animal Adoption and Caretaking Management System developed in Java using JDBC to interact with a MySQL database. The system allows users to manage information about animals, adopters, and caretakers, helping streamline the adoption and caretaking process.

Requirements
To run this project, ensure you have the following installed:

Java Development Kit (JDK): Version 8 or higher.
Apache Maven: For managing project dependencies and building the project.
MySQL Database: A running MySQL server with access credentials.
IntelliJ IDEA: Recommended IDE for Java development.
Database Setup
Create a Database:

Create a new database in MySQL named animal_adoption.
Create Tables:

Run the following SQL scripts to create necessary tables:

sql
Copy code
CREATE TABLE animals (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    species VARCHAR(50) NOT NULL,
    age INT,
    health_status VARCHAR(100)
);

CREATE TABLE adopters (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    contact_info VARCHAR(100) NOT NULL,
    address VARCHAR(100)
);

CREATE TABLE caretakers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    expertise VARCHAR(100),
    contact_info VARCHAR(100)
);
Configure Database Connection:

Update the DB_URL, USER, and PASSWORD constants in the JDBCConnector.java file to match your MySQL setup.
Project Setup
Clone the Repository:

bash
Copy code
git clone <repository-url>
cd animal_adoption_management
Navigate to Project Directory:

Ensure you are in the project directory where the pom.xml file is located.
Install Dependencies:

Run the following command to install project dependencies:

bash
Copy code
mvn install
Running the Project
Open IntelliJ IDEA:

Open the project in IntelliJ IDEA.
Run the Main Class:

Find the JDBCConnector class in the src/main/java/com/jdbc/connector directory.
Right-click on the class and select Run 'JDBCConnector.main()'.
Testing Functionality:

Uncomment lines in the main method of JDBCConnector to test adding animals, retrieving all animals, and other operations as needed.
Note
Ensure that your MySQL server is running and accessible with the provided credentials before running the project.
