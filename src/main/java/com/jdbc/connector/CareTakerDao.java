package com.jdbc.connector;

import java.util.List;

public interface CareTakerDao {
    // Adds a new donor to the data source
    void addCareTaker(CareTaker careTaker);

    // Retrieves a donor by their unique ID
    CareTaker getCareTakerById(int caretaker_id);

    // Retrieves a list of all donors
    List<CareTaker> getAllCareTaker();

    // Updates the details of an existing donor
    void updateCareTaker(CareTaker careTaker);

    // Deletes a donor by their unique ID
    void deleteCareTaker(int caretaker_id);

}
