package com.jdbc.connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDaoImpl implements AnimalDao{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/animal_adoption_care"; // Database URL
    private static final String USER = "root";  // MySQL username (replace as needed)
    private static final String PASSWORD = "1983";  // MySQL password (replace as needed)

    // Adds a Animal to the database
    @Override
    public void addAnimal(Animal animal) {
        String query = "INSERT INTO Animals (animal_id, name, species, age, is_adopted, caretaker_id) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, animal.getAnimal_id());
            preparedStatement.setString(2, animal.getName());
            preparedStatement.setString(3, animal.getSpecies());
            preparedStatement.setInt(4, animal.getAge());
            preparedStatement.setBoolean(5, animal.getIs_adopted());
            preparedStatement.setInt(6, animal.getCaretaker_id());
            preparedStatement.executeUpdate();
            System.out.println("Successfully added Animal");
        } catch (SQLException exception) {
            System.out.println("Error while adding Animal: " + exception.getMessage());
        }
    }

    // Retrieves an Animal from the database by ID
    @Override
    public Animal getAnimalById(int id) {
        String query = "SELECT * FROM Animals WHERE id = ?";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Animal(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getBoolean(5),
                        resultSet.getInt(6)
                );
            }
        } catch (SQLException exception) {
            System.out.println("Error while getting Animal: " + exception.getMessage());
        }
        return null;
    }

    // Retrieves all Animals from the database
    @Override
    public List<Animal> getAllAnimal() {
        List<Animal> Animals = new ArrayList<>();
        String query = "SELECT * FROM Animals";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Animals.add(new Animal(
                        resultSet.getInt("animal_id"),
                        resultSet.getString("name"),
                        resultSet.getString("species"),
                        resultSet.getInt("age"),
                        resultSet.getBoolean("is_adopted"),
                        resultSet.getInt("caretaker_id")
                ));
            }
        } catch (SQLException exception) {
            System.out.println("Error while getting all Animals: " + exception.getMessage());
        }
        return Animals;
    }

    // Updates a Animal's information in the database
    @Override
    public void updateAnimal(Animal animal) {
        String query = "UPDATE Animals SET name = ?, species = ?, age = ?, is_adopted = ?, caretaker_id = ? WHERE animal_id = ?";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, animal.getName());
            preparedStatement.setString(2, animal.getSpecies());
            preparedStatement.setInt(3, animal.getAge());
            preparedStatement.setBoolean(4, animal.getIs_adopted());
            preparedStatement.setInt(5, animal.getCaretaker_id());
            preparedStatement.setInt(6, animal.getAnimal_id());
            preparedStatement.executeUpdate();
            System.out.println("Successfully updated Animal");
        } catch (SQLException exception) {
            System.out.println("Error while updating Animal: " + exception.getMessage());
        }
    }

    // Deletes an Animal from the database by ID
    @Override
    public void deleteAnimal(int id) {
        String query = "DELETE FROM Animals WHERE animal_id = ?";
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Successfully deleted Animal");
        } catch (SQLException exception) {
            System.out.println("Error while deleting Animal: " + exception.getMessage());
        }
    }
}
