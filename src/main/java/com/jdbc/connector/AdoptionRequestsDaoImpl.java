package com.jdbc.connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdoptionRequestsDaoImpl implements AdoptionRequestsDao{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/animal_adoption_care"; // Database URL
    private static final String USER = "root";  // MySQL username (replace as needed)
    private static final String PASSWORD = "1983";  // MySQL password (replace as needed)

    // Adds a AdoptionRequests to the database
    @Override
    public void addAdoptionRequests(AdoptionRequests adoptionRequests) {
        String query = "INSERT INTO AdoptionRequests (request_id, animal_id, adopter_name, adopter_contact_info, request_date, status) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, adoptionRequests.getRequest_id());
            preparedStatement.setInt(2, adoptionRequests.getAnimal_id());
            preparedStatement.setString(3, adoptionRequests.getAdopter_name());
            preparedStatement.setString(4, adoptionRequests.getAdopter_contact_info());
            preparedStatement.setDate(5, adoptionRequests.getDate());
            preparedStatement.setString(6, adoptionRequests.getStatus());
            preparedStatement.executeUpdate();
            System.out.println("Successfully added AdoptionRequests");
        } catch (SQLException exception) {
            System.out.println("Error while adding AdoptionRequests: " + exception.getMessage());
        }
    }

    // Retrieves an AdoptionRequests from the database by ID
    @Override
    public AdoptionRequests getAdoptionRequestsById(int id) {
        String query = "SELECT * FROM AdoptionRequests WHERE id = ?";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new AdoptionRequests(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5),
                        resultSet.getString(6)
                );
            }
        } catch (SQLException exception) {
            System.out.println("Error while getting AdoptionRequests: " + exception.getMessage());
        }
        return null;
    }

    // Retrieves all AdoptionRequests from the database
    @Override
    public List<AdoptionRequests> getAllAdoptionRequests() {
        List<AdoptionRequests> AdoptionRequests = new ArrayList<>();
        String query = "SELECT * FROM AdoptionRequests";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                AdoptionRequests.add(new AdoptionRequests(
                        resultSet.getInt("request_id"),
                        resultSet.getInt("animal_id"),
                        resultSet.getString("adopter_name"),
                        resultSet.getString("adopter_contact_info"),
                        resultSet.getDate("request_date"),
                        resultSet.getString("status")
                ));
            }
        } catch (SQLException exception) {
            System.out.println("Error while getting all AdoptionRequests: " + exception.getMessage());
        }
        return AdoptionRequests;
    }

    // Updates a AdoptionRequest's information in the database
    @Override
    public void updateAdoptionRequests(AdoptionRequests adoptionRequests) {
        String query = "UPDATE AdoptionRequests SET animal_id = ?, adopter_name = ?, adopter_contact_info = ?, request_date = ?, status = ? WHERE request_id = ?";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, adoptionRequests.getAnimal_id());
            preparedStatement.setString(2, adoptionRequests.getAdopter_name());
            preparedStatement.setString(3, adoptionRequests.getAdopter_contact_info());
            preparedStatement.setDate(4, adoptionRequests.getDate());
            preparedStatement.setString(5, adoptionRequests.getStatus());
            preparedStatement.setInt(6, adoptionRequests.getRequest_id());
            preparedStatement.executeUpdate();
            System.out.println("Successfully updated AdoptionRequests");
        } catch (SQLException exception) {
            System.out.println("Error while updating AdoptionRequests: " + exception.getMessage());
        }
    }

    // Deletes an AdoptionRequests from the database by ID
    @Override
    public void deleteAdoptionRequests(int id) {
        String query = "DELETE FROM AdoptionRequests WHERE request_id = ?";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Successfully deleted AdoptionRequests");
        } catch (SQLException exception) {
            System.out.println("Error while deleting AdoptionRequests: " + exception.getMessage());
        }
    }
}
