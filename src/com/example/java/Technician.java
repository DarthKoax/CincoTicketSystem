package com.example.java;

import java.io.Serializable;

public class Technician implements Serializable {

    public String firstName;
    public String lastName;
    public String userName;
    public String level;
    // SerializeList cereal = new SerializeList();
    // TechnicianList technicians =  cereal.readTechnicianFile();

    public Technician() {

    }
    public Technician(String firstName, String lastName, String userName, String level) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.level = level;
    }


    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }


}
