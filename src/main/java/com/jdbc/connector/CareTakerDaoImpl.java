package com.jdbc.connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CareTakerDaoImpl implements CareTakerDao{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/animal_adoption_care"; // Database URL
    private static final String USER = "root";  // MySQL username (replace as needed)
    private static final String PASSWORD = "1983";  // MySQL password (replace as needed)

    // Adds a CareTaker to the database
    @Override
    public void addCareTaker(CareTaker careTaker) {
        String query = "INSERT INTO CareTakers (caretaker_id, name, contact_info) VALUES (?, ?, ?)";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, careTaker.getCaretaker_id());
            preparedStatement.setString(2, careTaker.getName());
            preparedStatement.setString(3, careTaker.getContact_info());
            preparedStatement.executeUpdate();
            System.out.println("Successfully added CareTaker");
        } catch (SQLException exception) {
            System.out.println("Error while adding CareTaker: " + exception.getMessage());
        }
    }

    // Retrieves an CareTaker from the database by ID
    @Override
    public CareTaker getCareTakerById(int id) {
        String query = "SELECT * FROM CareTakers WHERE caretaker_id = ?";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new CareTaker(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                );
            }
        } catch (SQLException exception) {
            System.out.println("Error while getting CareTaker: " + exception.getMessage());
        }
        return null;
    }

    // Retrieves all CareTakers from the database
    @Override
    public List<CareTaker> getAllCareTaker() {
        List<CareTaker> CareTakers = new ArrayList<>();
        String query = "SELECT * FROM CareTakers";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CareTakers.add(new CareTaker(
                        resultSet.getInt("caretaker_id"),
                        resultSet.getString("name"),
                        resultSet.getString("contact_info")
                ));
            }
        } catch (SQLException exception) {
            System.out.println("Error while getting all CareTakers: " + exception.getMessage());
        }
        return CareTakers;
    }

    // Updates a CareTaker's information in the database
    @Override
    public void updateCareTaker(CareTaker careTaker) {
        String query = "UPDATE CareTakers SET name = ?, species = ? WHERE careTaker_id = ?";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, careTaker.getName());
            preparedStatement.setString(2, careTaker.getContact_info());
            preparedStatement.setInt(3, careTaker.getCaretaker_id());
            preparedStatement.executeUpdate();
            System.out.println("Successfully updated CareTaker");
        } catch (SQLException exception) {
            System.out.println("Error while updating CareTaker: " + exception.getMessage());
        }
    }

    // Deletes an CareTaker from the database by ID
    @Override
    public void deleteCareTaker(int id) {
        String query = "DELETE FROM CareTakers WHERE id = ?";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Successfully deleted CareTaker");
        } catch (SQLException exception) {
            System.out.println("Error while deleting CareTaker: " + exception.getMessage());
        }
    }
}
