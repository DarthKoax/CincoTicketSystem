package com.example.java;

import java.io.*;

public class SerializeList implements Serializable {

    String ticketData = "TicketData.ser";
    String technicianData = "TechnicianData.ser";


    // receive an ArrayList<Ticket> object and Serialize it to TicketData.ser
    public void writeTicketFile(TicketList tickets) {
        // System.out.println("Saving List..");
        try {
            FileOutputStream fileStream = new FileOutputStream(ticketData);
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            objectStream.writeObject(tickets);
            objectStream.close();
            fileStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public TicketList readTicketFile() {
        TicketList tickets;
        tickets = new TicketList();
        // System.out.println("Opening List..");

        try {

            FileInputStream fileStream = new FileInputStream(ticketData);
            ObjectInputStream objectStream = new ObjectInputStream(fileStream);

            tickets = (TicketList) objectStream.readObject();

            objectStream.close();
            fileStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("No Ticket Data Found.");
        } catch (ClassNotFoundException | InvalidClassException e) {
            // e.printStackTrace();
            System.out
                    .println("Warning: Data may be Corrupt. Corrupt Data will be overwritten and is not recoverable.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tickets;
    }
    /*
    ---------------------
    Technician List Methods. 
    ---------------------
    */
    public void writeTechnicianFile(TechnicianList technicians) {
        // System.out.println("Saving List..");
        try {
            FileOutputStream fileStream = new FileOutputStream(technicianData);
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            objectStream.writeObject(technicians);
            objectStream.close();
            fileStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public TechnicianList readTechnicianFile() {
        TechnicianList technicians;
        technicians = new TechnicianList();
        // System.out.println("Opening List..");

        try {

            FileInputStream fileStream = new FileInputStream(technicianData);
            ObjectInputStream objectStream = new ObjectInputStream(fileStream);

            technicians = (TechnicianList) objectStream.readObject();

            objectStream.close();
            fileStream.close();

        } catch (FileNotFoundException e) {
                System.out.println("No Technician Data Found.");
        } catch (ClassNotFoundException | InvalidClassException e) {
            // e.printStackTrace();
            System.out
                    .println("Warning: Data may be Corrupt. Corrupt Data will be overwritten and is not recoverable.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return technicians;
    }
}
