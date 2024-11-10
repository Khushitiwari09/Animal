package com.jdbc.connector;
import java.util.List;

// This interface defines the operations for managing Animals records in the data source
public interface AnimalDao {
    // Adds a new donor to the data source
    void addAnimal(Animal animal);

    // Retrieves a donor by their unique ID
    Animal getAnimalById(int id);

    // Retrieves a list of all donors
    List<Animal> getAllAnimal();

    // Updates the details of an existing donor
    void updateAnimal(Animal animal);

    // Deletes a donor by their unique ID
    void deleteAnimal(int id);

}
