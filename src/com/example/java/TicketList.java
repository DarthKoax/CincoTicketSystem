package com.example.java;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class TicketList implements Serializable, Iterable<Ticket> {

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

        int tid = 1;

        if (tickets != null && !tickets.isEmpty()) {
            Ticket item = tickets.get(tickets.size() - 1);
            tid = item.id + 1;
        }
        return tid;
    }

    public int getNumberOpenTickets() {
        int numTickets = 0;
        if (tickets != null && !tickets.isEmpty()) {
            for (Ticket t : tickets) {
                if (t.getStatus().equalsIgnoreCase("OPEN")) {
                    numTickets++;
                }
            }
        }
        return numTickets;
    }



    public void getTicketsListLowAndMedium() {
        boolean first = true;
        for (Ticket t : tickets) {
            if (t.getSeverity().equals("LOW") || t.getSeverity().equals("MEDIUM")) {
                if (first) {
                    System.out.println("List of Open Tickets\n=====================\n");
                    first = false;
                }

                System.out.println(t.listTickets());
            }
        }
    }

    public void getTicketsListHigh() {
        boolean first = true;
        for (Ticket t : tickets) {
            if (t.getSeverity().equals("HIGH")) {
                if (first) {
                    System.out.println("List of Open Tickets\n=====================\n");
                    first = false;
                }

                System.out.println(t.listTickets());
            }
        }
    }

    public void getRequestedTicket(int num) {

        if (tickets != null && !tickets.isEmpty()) {
            for (Ticket t : tickets) {
                if (t.getId() == num) {
                    System.out.println(t);
                }
            }
        }

    }

    public boolean closeRequestedTicket(int num) {

        boolean outcome = false;

        if (tickets != null && !tickets.isEmpty()) {
            for (Ticket t : tickets) {
                if (t.getId() == num) {
                    t.setStatusClosed();
                    outcome = true;
                }
            }
        }

        return outcome;
    }

    public boolean setTicketSeverity(int num, String severity) {

        boolean outcome = false;

        if (tickets != null && !tickets.isEmpty()) {
            for (Ticket t : tickets) {
                if (t.getId() == num) {
                    if (severity.equalsIgnoreCase("H")){
                        t.setSeverityHigh();
                        outcome = true;
                    } else if(severity.equalsIgnoreCase("M")){
                        t.setSeverityMedium();
                        outcome = true;
                    } else if(severity.equalsIgnoreCase("L")){
                        t.setSeverityLow();
                        outcome = true;
                    }
                }
            }
        }

        return outcome;
    }
}