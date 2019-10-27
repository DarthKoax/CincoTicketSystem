package com.example.java;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DataReadWrite{

    //Ticket data is stored in Tickets.dat separated using ;

    public Ticket ticket;
    
    /* Ticket Variables
    public String firstName;
    public String lastName;
    public String staffNumber;
    public String submitTicket;
    public String email;
    public String contact;
    public String description;
    public String severity;
    */
    
    
    //This class can read the tickets stored in the external file
    //and also write ticket objects to the external file

    //Constructor


    //Method to open the file, read the contents, create an array of Ticket objects, 
    //and pass the array of Ticket objects back out

    public ArrayList<Ticket> readStoredTicketData(){
        
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        File file = new File("Tickets.dat");
        
        try{
            Scanner scanner = new Scanner(file).useDelimiter(";");

            while (scanner.hasNextLine()){
                String firstName = scanner.next();
                String lastName = scanner.next();
                String staffNumber = scanner.next();
                String email = scanner.next();
                String contact = scanner.next();
                String description = scanner.next();
                String severity = scanner.next();

                tickets.add(new Ticket(firstName, lastName, staffNumber, email, contact, description, severity));
                scanner.nextLine();
            }
            
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        
        return tickets;
    }

    public void writeOneTicket(Ticket ticket){
        //Appends one ticket to file
    }

    public void writeAllTickets(){
        //Writes all tickets to file
    }    

    //Method to receive a Ticket object, open a file and put the ticket info into the file. 
    //Should also check to see if the ticket is already listed in the file.

}