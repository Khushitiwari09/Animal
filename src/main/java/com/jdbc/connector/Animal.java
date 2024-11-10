package com.jdbc.connector;

public class Animal {
    private int animal_id;
    private String name;
    private String species;
    private int age;
    private Boolean is_adopted;
    private int caretaker_id;

    public Animal(int animal_id, String name, String species, int age, Boolean is_adopted, int caretaker_id) {
        this.animal_id = animal_id;
        this.name = name;
        this.species = species;
        this.age = age;
        this.is_adopted = is_adopted;
        this.caretaker_id = caretaker_id;
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(int animal_id) {
        this.animal_id = animal_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getIs_adopted() {
        return is_adopted;
    }

    public void setIs_adopted(Boolean is_adopted) {
        this.is_adopted = is_adopted;
    }

    public int getCaretaker_id() {
        return caretaker_id;
    }

    public void setCaretaker_id(int caretaker_id) {
        this.caretaker_id = caretaker_id;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animal_id=" + animal_id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", age=" + age +
                ", is_adopted=" + is_adopted +
                ", caretaker_id=" + caretaker_id +
                '}';
    }
}