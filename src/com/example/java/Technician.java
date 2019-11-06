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


    // load the technicians when the main starts
    // public void loadTechnicians() {

    //     if (technicians.size() == 0 || technicians.equals(null)) {

    //         Technician technician = new Technician();

    //         Technician harry = new Technician("Harry", "Styles", "harry.styles", "1");
    //         Technician niall = new Technician("Niall", "Horan", "niall.horan", "1");
    //         Technician liam = new Technician("Liam", "Payne", "liam.payne", "1");
    //         Technician louis = new Technician("Louis", "Tomlinsonand", "louis.tomlinsonand", "2");
    //         Technician zayn = new Technician("Zayn", "Malik", "zayn.malik", "2");

    //         technicians.add(harry);
    //         technicians.add(niall);
    //         technicians.add(liam);
    //         technicians.add(louis);
    //         technicians.add(zayn);

    //         cereal.writeTechnicianFile(technicians);
    //     }

    // }
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
