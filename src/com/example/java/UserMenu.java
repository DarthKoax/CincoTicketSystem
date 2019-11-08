package com.example.java;

import java.util.Scanner;
import java.util.stream.Stream;

public class UserMenu {

    // Load Ticket Data on startup
    SerializeList cereal = new SerializeList();
    TicketList tickets = cereal.readTicketFile();
    Scanner scanner = new Scanner(System.in);

    public static final String LINE1 = "-------------------------------------------------";
    public static final String LINE2 = "|          CINCO  TICKET ISSUING SYSTEM         |";
    public static final String LINE3 = "|                  GENERAL USER                 |";
    public static final String LINE4 = "|                                               |";
    public static final String LINE5 = "|           1.    SUBMIT NEW TICKET             |";
    public static final String LINE7 = "";
    public static final String LINE8 = "|           3.    LOG OUT                       |";

    public String selection;

    // Stream<String> userMenuStream = Stream.of(new String[] { LINE1, LINE2, LINE3, LINE4, LINE5, LINE8, LINE4, LINE1 });

    public void printUserMenu() {
        while (true) {
            Stream<String> userMenuStream = Stream
                    .of(new String[] { LINE1, LINE2, LINE3, LINE4, LINE5, LINE8, LINE4, LINE1 });

            userMenuStream.forEach(p -> System.out.println(p));
            System.out.println("Select Option...");
            selection = getOption();
            callMenuFeature(selection);
        }

    }

    public String getOption() {
        String level = null;
        do {
            level = scanner.nextLine();

        } while (!level.equals("1") && !level.equals("2") && !level.equals("3"));
        return level;
    }

    public void callMenuFeature(String selection) {
        switch (selection) {
        case "1":
            Ticket ticket = new Ticket();
            if (ticket.getTicketInput() == false) {
            } else {
                tickets.add(ticket);
                cereal.writeTicketFile(tickets);
            }
            break;
        case "2":
            /*
             * DEBUG: print each Ticket in Tickets for(Ticket t: tickets){
             * System.out.println(t); }
             */
            System.out.println("Not yet implemented");
            break;
        case "3":
            System.out.println("Exit the system ");
            System.exit(0);
            break;
        default:
            System.out.println("Something went very wrong");
        }
    }

}
