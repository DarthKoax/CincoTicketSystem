package com.example.java;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class TicketList implements Serializable, Iterable<Ticket>{

   private static final long serialVersionUID = 1L;
   public final ArrayList<Ticket> tickets = new ArrayList<Ticket>();

   public void add(Ticket ticket) {
      tickets.add(ticket);
   }

   public int size() {
      return tickets.size();
   }

   @Override
   public Iterator<Ticket> iterator() {
      return tickets.iterator();
   }

   /*
    * 
    * ---- Below still in use but redundant 1/11/19---
    */

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


   public int getLastId() {

      int tid =0;
      if (tickets != null && !tickets.isEmpty()) {
         Ticket item = tickets.get(tickets.size()-1);
        // x =  item.id;
         tid = item.id + 1;
      }
      return tid;
   }

}