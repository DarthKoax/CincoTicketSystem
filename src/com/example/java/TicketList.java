package com.example.java;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.ParseException;


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
     *
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

    public int getNumberAssignedTickets(String user) {
        int numTickets = 0;
        if (tickets != null && !tickets.isEmpty()) {
            for (Ticket t : tickets) {
                if (t.getStatus().equalsIgnoreCase("OPEN") && t.getTechUserName().equalsIgnoreCase(user)) {
                    numTickets++;
                }
            }
        }
        return numTickets;
    }

    public void getArchivedTicket()
    {	
    	System.out.println ("List of Archived Tickets\n=====================\n");
    	for (Ticket t : tickets)
    	{
           if (t.status.equalsIgnoreCase("closed"))
           {
              System.out.println(t.archivedTickets());
           }
        }
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

    public void getTicketsListTechnician(String technician) {
        boolean first = true;
        for (Ticket t : tickets) {
            if (t.getTechUserName().equals(technician)) {
                if (first) {
                    System.out.println("List of Assigned Tickets\n=====================\n");
                    first = false;
                }

                System.out.println(t.listTickets());
            }
        }
    }

    public void ticketsPerTechnician(){
        if (tickets != null && !tickets.isEmpty()) {
            String harry = "HARRY STYLES:";
            String nial = "NIALL HORAN:";
            String liam = "LIAM PAYNE:";
            String louis = "LOUIS TOMLINSON:";
            String zayn = "ZAYN MALIK:";
            for (Ticket t : tickets) {
                if (t.getTechUserName().equalsIgnoreCase("harry.styles")) {
                    harry = harry.concat(" "+ t.getId());
                } else if (t.getTechUserName().equalsIgnoreCase("niall.horan")) {
                    nial = nial.concat(" "+ t.getId());
                } else if (t.getTechUserName().equalsIgnoreCase("liam.payne")) {
                    liam = liam.concat(" "+ t.getId());
                } else if (t.getTechUserName().equalsIgnoreCase("louis.tomlinson")) {
                    louis = louis.concat(" "+ t.getId());
                } else if (t.getTechUserName().equalsIgnoreCase("zayn.malik")) {
                    zayn = zayn.concat(" "+ t.getId());
                }
            }
            System.out.println(harry);
            System.out.println(nial);
            System.out.println(liam);
            System.out.println(louis);
            System.out.println(zayn);
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

    public void getRequestedClosedTicket(int num) {

        if (tickets != null && !tickets.isEmpty()) {
            for (Ticket t : tickets) {
                if (t.getId() == num && t.getStatus().equalsIgnoreCase("closed")) {
                    System.out.println(t);
                }
            }
        }

    }
    
    public boolean getRequestedTicket(int num, String user) {

        boolean result = false;
        if (tickets != null && !tickets.isEmpty()) {
            for (Ticket t : tickets) {
                if (t.getId() == num && t.getTechUserName().equalsIgnoreCase(user)) {
                    System.out.println(t);
                    result = true;
                }
            }
        }
        return result;
    }
    
    public void getArchivedTicket(int num) {

        if (tickets != null && !tickets.isEmpty()) {
            for (Ticket t : tickets) {
                if (t.status == "closed") {
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
                    t.techUserName = ("n/a");
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
                    if (severity.equalsIgnoreCase("H")) {
                        t.setSeverityHigh();
                        outcome = true;
                    } else if (severity.equalsIgnoreCase("M")) {
                        t.setSeverityMedium();
                        outcome = true;
                    } else if (severity.equalsIgnoreCase("L")) {
                        t.setSeverityLow();
                        outcome = true;
                    }
                }
            }
        }

        return outcome;
    }


    /**
     * get technician name who ticket will be assigned too
     * if no tickets previously assigned , know that all technicians have 0 tickets
     *
     * @param severity
     * @return
     */
    public String getTechName(String severity) {

        CalculateTechName tc = new CalculateTechName();
        String technameReturn = null;


        if (tickets != null && !tickets.isEmpty()) {
            technameReturn = tc.calcTechUser(severity);
        } else {
            if (severity.equalsIgnoreCase("HIGH")) {
                technameReturn = tc.calcLevel2Technician();
            } else {
                technameReturn = tc.calcLevel1Technician();
            }
        }

        return technameReturn;
    }


    /**
     * Set the Technical userid for the corresponding Ticket
     *
     * @param num
     * @return
     */

    public boolean setTechUserName(int num) {
        CalculateTechName tc = new CalculateTechName();
        boolean outcome = false;

        if (tickets != null && !tickets.isEmpty()) {
            for (Ticket t : tickets) {
                if (t.getId() == num) {
                    String technameReturn = tc.calcTechUser(t.severity);
                    t.setTechUserName(technameReturn);
                    outcome = true;
                }
            }
        }

        return outcome;
    }

    public boolean setTechUserNameBlank(int num) {
        boolean outcome = false;

        if (tickets != null && !tickets.isEmpty()) {
            for (Ticket t : tickets) {
                if (t.getId() == num) {
                    String technameReturn = "";
                    t.setTechUserName(technameReturn);
                    outcome = true;
                }
            }
        }

        return outcome;
    }
    
    public void ClearOutOfDate() {
        int daysToArchiveAfter = 7;
        System.out.println("Clearing out of date tickets");
        Calendar currentDate = Calendar.getInstance();
        for (Ticket t : tickets) {
            if (t.getStatus().equalsIgnoreCase("OPEN")) {
                Calendar ticketToCheck = (Calendar) t.date.clone();
                ticketToCheck.add(Calendar.DATE,daysToArchiveAfter);
                if (currentDate.after(ticketToCheck)) {
                    boolean closed = closeRequestedTicket(t.getId());
                    if (closed) {System.out.println("Ticked expired.");};
                } else {
                    System.out.println("Ticket is not 7 days old");
                } // if
            }//if
            
        } // for
    }// CleaerOutOfDate
}//end of class




