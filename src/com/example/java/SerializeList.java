package com.example.java;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import java.io.FileNotFoundException;

public class SerializeList {

    String fileLocation = "TicketData.ser";

    // receive an ArrayList<Ticket> object and Serialize it to TicketData.ser
    public void writeFile(TicketList tickets) {
        System.out.println("Saving List..");
        try {
            FileOutputStream fileStream = new FileOutputStream(fileLocation);
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            objectStream.writeObject(tickets);
            objectStream.close();
            fileStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TicketList readFile() {
        TicketList tickets;
        tickets = new TicketList();
        System.out.println("Opening List..");

        try {
            /*
             * File file = new File(fileLocation); if(!file.exists()){ file.createNewFile();
             * }
             */
            FileInputStream fileStream = new FileInputStream(fileLocation);
            ObjectInputStream objectStream = new ObjectInputStream(fileStream);

            // This is an unchecked cast so will produce a warning during compile time,
            // However, at no point should a non Ticket object end up in the ArrayList<Ticket>
            tickets = (TicketList) objectStream.readObject();

            objectStream.close();
            fileStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("Loading Ticket Data...");
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
}
