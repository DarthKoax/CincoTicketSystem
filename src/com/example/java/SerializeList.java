package com.example.java;

import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class SerializeList{

    String fileLocation = "TicketData.ser";

    //receive an ArrayList<Ticket> object and Serialize it to TicketData.ser
    public void writeFile(ArrayList<Ticket> tickets){
        try{
            FileOutputStream fileStream = new FileOutputStream(fileLocation);
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            objectStream.writeObject(tickets);
            objectStream.close();
            fileStream.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Ticket> readFile(){
        ArrayList<Ticket> tickets;
        tickets = new ArrayList<Ticket>();

        try{
            FileInputStream fileStream = new FileInputStream(fileLocation);
            ObjectInputStream objectStream = new ObjectInputStream(fileStream);
            //This is an unchecked cast so will produce a warning suring compile time,
            //However, at no point should a non Ticket object end up in the ArrayList<Ticket>
            tickets = (ArrayList<Ticket>)objectStream.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return tickets;
    }

}