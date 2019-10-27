package com.example.java;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Tests {

   private String firstName = "Bob";
   private String lastName = "Brown";
   private String staffNumber = "1234";
   private String submitTicket = "Y";
   private String email = "bob.brown@cinco.net";
   private String contact = "045555555";
   private String description = "cant find the internet";
   private String severity = "H";

   public Tests() {

   }

   public void testTicket() {
      // UPDATE HERE TO MATCH CONTRUCTOR
      Ticket ticket = new Ticket(firstName, lastName, staffNumber, submitTicket, email, contact, description, severity);
      testTicketFirstname(ticket);
      testTicketLastname(ticket);
      testTicketStaffnumber(ticket);
      testTicketSubmitticket(ticket);
      testTicketEmail(ticket);
      testTicketContact(ticket);
      testTicketDescription(ticket);
      testTicketSeverity(ticket);

   }

   public void testTicketOpen() {
      // UPDATE HERE TO MATCH CONTRUCTOR
      Ticket ticketOpen = new Ticket(firstName, lastName, staffNumber, submitTicket, email, contact, description,
            severity);
      assert (ticketOpen.status == "Open") : "Ticket is closed or null, Should be open.";
   }

   public void testTicketClosed() {
      // UPDATE HERE TO MATCH CONTRUCTOR
      Ticket ticketOpen = new Ticket(firstName, lastName, staffNumber, submitTicket, email, contact, description,
            severity);
      assert (ticketOpen.status == "Closed") : "Ticket is open or null, Should be closed.";
   }

   private Ticket setTicketClosed(Ticket ticket){
      ticket.close(); //Define Method
      return ticket;
   }
   private void testTicketFirstname(Ticket ticket){
      assert (ticket.firstName = firstName) != null;
   }

   private void testTicketLastname(Ticket ticket){
      assert (ticket.lastName = lastName) != null;
   }

   private void testTicketStaffnumber(Ticket ticket){
      assert (ticket.staffNumber = staffNumber) != null;
   }

   private void testTicketSubmitticket(Ticket ticket){
      assert (ticket.submitTicket = submitTicket) != null;
   }

   private void testTicketEmail(Ticket ticket){
      assert (ticket.email = email) != null;
   }

   private void testTicketContact(Ticket ticket){
      assert (ticket.contact = contact) != null;
   }

   private void testTicketDescription(Ticket ticket){
      assert (ticket.description = description) != null;
   }

   private void testTicketSeverity(Ticket ticket){
      assert (ticket.severity = severity) != null;
   }

}