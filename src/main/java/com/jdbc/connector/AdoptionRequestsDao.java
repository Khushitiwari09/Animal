package com.jdbc.connector;

import java.util.List;

public interface AdoptionRequestsDao {
    // Adds a new donor to the data source
    void addAdoptionRequests(AdoptionRequests adoptionRequests);

    // Retrieves a donor by their unique ID
    AdoptionRequests getAdoptionRequestsById(int caretaker_id);

    // Retrieves a list of all donors
    List<AdoptionRequests> getAllAdoptionRequests();

    // Updates the details of an existing donor
    void updateAdoptionRequests(AdoptionRequests adoptionRequests);

    // Deletes a donor by their unique ID
    void deleteAdoptionRequests(int caretaker_id);

}
