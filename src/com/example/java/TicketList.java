package com.example.java;

import java.io.Serializable;
import java.util.ArrayList;

public class TicketList implements Serializable {

   private static final long serialVersionUID = 1L;
   private final ArrayList<Ticket> tickets = new ArrayList<Ticket>();

   public void add(Ticket ticket) {
      tickets.add(ticket);
   }

   public int size() {
      return tickets.size();
   }

   public void getTicketsLowAndMedium() {
      for (Ticket t : tickets) {
         if (t.getSeverity().equals("LOW") || t.getSeverity().equals("MEDIUM")) {
            System.out.println(t);
         }
      }
   }

   public void getTicketsHigh() {
      for (Ticket t : tickets) {
         if (t.getSeverity().equals("HIGH")) {
            System.out.println(t);
         }
      }
   }

}