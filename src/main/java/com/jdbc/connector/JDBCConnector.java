package com.jdbc.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.sql.Date;

public class JDBCConnector {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/animal_adoption_care";
    private static final String USER = "root";  // Change this to your MySQL username
    private static final String PASSWORD = "1983";  // Change this to your MySQL password

    public JDBCConnector() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connected to the database successfully.");
        } catch (SQLException e) {
            System.out.println("Error in connecting to database "+e.getMessage());
        }
    }
    public static void main(String[] args) {
        CareTakerDao careTakerDao = new CareTakerDaoImpl();
        //CareTaker careTaker = new CareTaker(1,"Ayush", "Email: aagarwala073@gmail.com , Phone: 9711228842");
        //careTakerDao.addCareTaker(careTaker);
        List<CareTaker> careTakers = careTakerDao.getAllCareTaker();
        System.out.println(careTakers.toString());

        AnimalDao animalDao = new AnimalDaoImpl();
        //Animal animal = new Animal(1,"Jimmy","Dog",10,Boolean.FALSE,1);
        //animalDao.addAnimal(animal);
        List<Animal> animals = animalDao.getAllAnimal();
        System.out.println(animals.toString());

        AdoptionRequestsDao adoptionRequestsDao = new AdoptionRequestsDaoImpl();
        //AdoptionRequests adoptionRequests = new AdoptionRequests(1,1,"Vaibhav","6768768767",new Date(2024,11,10),"Success");
        //adoptionRequestsDao.addAdoptionRequests(adoptionRequests);
        List<AdoptionRequests> adoptionRequestsList = adoptionRequestsDao.getAllAdoptionRequests();
        System.out.println(adoptionRequestsList.toString());
    }
}
