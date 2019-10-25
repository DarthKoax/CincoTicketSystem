package com.example.java;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class UserMenu {
    Scanner scanner = new Scanner(System.in);
    public static final String LINE1 = "-------------------------------------------------";
    public static final String LINE2 = "|          CINCO  TICKET ISSUING SYSTEM         |";
    public static final String LINE3 = "|                  GENERAL USER                 |";
    public static final String LINE4 = "|                                               |";
    public static final String LINE5 = "|           1.    SUBMIT NEW TICKET             |";
    public static final String LINE6 = "|           2. OPEN / ARCHIVED TICKETS          |";
    public static final String LINE7 = "";
    public static final String LINE8 = "|           3.      EXIT SYSTEM                 |";

    public String selection;

    Stream<String> userMenuStream = Stream
            .of(new String[] { LINE1, LINE2, LINE3, LINE4, LINE5, LINE6, LINE8, LINE4, LINE1 });

    public void printUserMenu() {
        userMenuStream.forEach(p -> System.out.println(p));
        System.out.print("Select Option...");
        selection = getOption();
        callMenuFeature(selection);
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
            ticket.getTicketInput();
            break;
        case "2":
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
