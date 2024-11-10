package com.jdbc.connector;

public class CareTaker {
    private int caretaker_id; // Donor's unique identifier
    private String name; // Donor's name
    private String contact_info; // Donor's blood type

    public CareTaker(int caretaker_id, String name, String contact_info) {
        this.caretaker_id = caretaker_id;
        this.name = name;
        this.contact_info = contact_info;
    }

    public int getCaretaker_id() {
        return caretaker_id;
    }

    public void setCaretaker_id(int caretaker_id) {
        this.caretaker_id = caretaker_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact_info() {
        return contact_info;
    }

    public void setContact_info(String contact_info) {
        this.contact_info = contact_info;
    }

    @Override
    public String toString() {
        return "CareTaker{id=" + caretaker_id + ", name='" + name + "', contact info='" + contact_info + "'}";
    }
}
