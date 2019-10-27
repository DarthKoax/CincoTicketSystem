package com.example.java;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class DataReadWrite{

    //Ticket data is stored in Tickets.dat separated using ;

    public Ticket ticket;    
    
    //This class can read the tickets stored in the external file
    //and also write a ArrayList<Ticket> to the external file

    //Method to read the stored external Ticket data file
    //returns an ArrayList<Ticket> of the imported objects
    public ArrayList<Ticket> readStoredTicketData(){
        
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        File file = new File("Tickets.dat");
        System.out.println("Loading Ticket Data...");

        try{
            Scanner scanner = new Scanner(file).useDelimiter("\t");

            while (scanner.hasNextLine()){
                String firstName = scanner.next();
                String lastName = scanner.next();
                String staffNumber = scanner.next();
                String email = scanner.next();
                String contact = scanner.next();
                String description = scanner.next();
                String severity = scanner.next();
                String status = scanner.next();

                tickets.add(new Ticket(firstName, lastName, staffNumber, email, contact, description, severity, status));
            }
            System.out.println("Ticket data Loaded.");
            
        } catch (FileNotFoundException e){
            System.out.println("Ticket data not Found.");
        } 
        
        return tickets;
    }

    //public void writeOneTicket(Ticket ticket){
        //Appends one ticket to file
    //}

    //This method receives an ArrayList<Ticket>, checks if the external file exists
    //creates a file, if needed, then writes the data from each Ticket object into the 
    //external file.
    public void writeAllTickets(ArrayList<Ticket> tickets){
        
        //Writes all tickets to file

        File file = new File("Tickets.dat");

        try{
            if(!file.exists()){
                file.createNewFile();
            }
            
            FileWriter fileWriter = new FileWriter("Tickets.dat"); 
              
            for (Ticket ticket:tickets){
                System.out.println("About to Write a ticket to file: "+ticket.toString());
                fileWriter.write(ticket.toString(true));
                fileWriter.flush();                
            }    
            fileWriter.close();
            System.out.println("Ticket data Saved.");
            
        } catch (IOException e) {
            System.out.println("Ticket data Save Error.");
        }

    }    

}