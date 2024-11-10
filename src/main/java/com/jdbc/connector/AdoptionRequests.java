package com.jdbc.connector;
import java.sql.Date;

public class AdoptionRequests {
    private int request_id;
    private int animal_id;
    private String adopter_name;
    private String adopter_contact_info;
    private Date date;
    private String status;

    public AdoptionRequests(int request_id, int animal_id, String adopter_name, String adopter_contact_info, Date date, String status) {
        this.request_id = request_id;
        this.animal_id = animal_id;
        this.adopter_name = adopter_name;
        this.adopter_contact_info = adopter_contact_info;
        this.date = date;
        this.status = status;
    }

    public AdoptionRequests(int request_id, int animal_id, String adopter_name, String adopter_contact_info, Date date) {
        this.request_id = request_id;
        this.animal_id = animal_id;
        this.adopter_name = adopter_name;
        this.adopter_contact_info = adopter_contact_info;
        this.date = date;
    }

    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(int animal_id) {
        this.animal_id = animal_id;
    }

    public String getAdopter_name() {
        return adopter_name;
    }

    public void setAdopter_name(String adopter_name) {
        this.adopter_name = adopter_name;
    }

    public String getAdopter_contact_info() {
        return adopter_contact_info;
    }

    public void setAdopter_contact_info(String adopter_contact_info) {
        this.adopter_contact_info = adopter_contact_info;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AdoptionRequests{" +
                "request_id=" + request_id +
                ", animal_id=" + animal_id +
                ", adopter_name='" + adopter_name + '\'' +
                ", adopter_contact_info='" + adopter_contact_info + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                '}';
    }
}
