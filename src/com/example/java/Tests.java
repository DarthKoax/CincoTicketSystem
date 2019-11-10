package com.example.java;


public class Tests {

   private String firstName = "Bob";
   private String lastName = "Brown";
   private String staffNumber = "1234";
   private String email = "test.ticket@cinco.net";
   private String contact = "045555555";
   private String description = "cant find the internet";
   private String severity = "H";
   private String status = "OPEN";
   private int id =  0;


   public Tests() {

   }

   public Ticket addTicketCusomDate(int year, int month, int day){
      int fancyMonth = month - 1;
      Ticket ticket = new Ticket(firstName, lastName, staffNumber, email, contact, description, severity,status, id,year,fancyMonth,day);
      ticket.setStatusOpen();
      return ticket;
   }

   public void testTicket() {
      // UPDATE HERE TO MATCH CONSTRUCTOR
      Ticket ticket = new Ticket(firstName, lastName, staffNumber, email, contact, description, severity,status, id);
      testTicketFirstname(ticket);
      testTicketLastname(ticket);
      testTicketStaffnumber(ticket);
      testTicketEmail(ticket);
      testTicketContact(ticket);
      testTicketDescription(ticket);
      testTicketSeverity(ticket);
      testTicketID(ticket);

   }

   public void testTicketOpen() {
      // UPDATE HERE TO MATCH CONTRUCTOR

      Ticket ticket = new Ticket(firstName, lastName, staffNumber, email, contact, description, severity,status,id);
      assert (ticket.status == "open") : "Ticket is closed or null, Should be open.";
   }

   public void testTicketClosed() {
      // UPDATE HERE TO MATCH CONTRUCTOR
      Ticket ticket = new Ticket(firstName, lastName, staffNumber, email, contact, description,
              severity, status = "closed",id);
      assert (ticket.status == "closed") : "Ticket is open or null, Should be closed.";
   }


   private void testTicketFirstname(Ticket ticket) {
      assert (ticket.firstName == firstName);
   }

   private void testTicketLastname(Ticket ticket) {
      assert (ticket.lastName == lastName);
   }

   private void testTicketStaffnumber(Ticket ticket) {
      assert (ticket.staffNumber == staffNumber);
   }


   private void testTicketEmail(Ticket ticket) {
      assert (ticket.email == email);
   }

   private void testTicketContact(Ticket ticket) {
      assert (ticket.contact == contact) ;
   }

   private void testTicketDescription(Ticket ticket) {
      assert (ticket.description == description);
   }

   private void testTicketSeverity(Ticket ticket) {
      assert (ticket.severity == severity);
   }

   private void testTicketID(Ticket ticket) {
      assert (ticket.id == id);
   }

}