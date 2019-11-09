package com.example.java;

import java.util.Scanner;
import java.util.stream.Stream;

public class TechMenu {
    Scanner scanner = new Scanner(System.in);

    public Ticket ticket;
    // Load Ticket Data on startup
    SerializeList cereal = new SerializeList();
    TicketList tickets = cereal.readTicketFile();
    TechnicianList technicians = cereal.readTechnicianFile();
    Technician technician = new Technician();

    int numOpenTickets;
    String techUserName;

    public static final String LINE1 = "-------------------------------------------------";
    public static final String LINE2 = "|          CINCO  TICKET ISSUING SYSTEM         |";
    public static final String LINE3 = "|                TECHNICIAN USER                |";
    public static final String LINE4 = "|                                               |";
    public static final String LINE5 = "|           1.  LEVEL 1 SERVICE DESK            |";
    public static final String LINE6 = "|           2.  LEVEL 2 SERVICE DESK            |";
    public static final String LINE7 = "";
    public static final String LINE8 = "|           3.  LOG OUT                         |";
    public static final String LINE9 = "               LEVEL 1 SERVICE DESK TICKETS    ";
    public static final String LINE10 = "               LEVEL 2 SERVICE DESK TICKETS    ";

    public String loginOption;
    public String userNameTech;

    public void printTechMenu(Technician currentUser) {

        while (true) {
            formatTechMenu(currentUser);

            loginOption = getServiceDesk();
            validateLogin(loginOption, currentUser);
        }
    }

    public String getServiceDesk() {
        String level = null;
        do {
            System.out.println("You can only enter option '1' , '2' ,'3'");
            level = scanner.nextLine();

        } while (!level.equals("1") && !level.equals("2") && !level.equals("3"));
        return level;
    }

    public void validateLogin(String loginOption, Technician tech) {
        switch (loginOption) {
        case "1":

            level1Login(tech);
            break;
        case "2":

            level2Login(tech);
            break;
        case "3":
            System.out.println("Exit the system ");
            System.exit(0);
            break;
        default:
            System.out.println(loginOption);
            System.out.println("Something went very wrong");
        }
    }

    public String getSpaceLeft(Integer sl, Integer num) {
        int spaceLength = sl;
        int numL = String.valueOf(num).length();
        int count = sl - numL;
        String spaceCalc = String.format("%" + count + "c", ' ');
        return spaceCalc;
    }

    public void level1Login(Technician user) {

        // String first = technicians.getFirstName(userNameTech);
        // String last = technicians.getLastName(userNameTech);
        // String techie1 = first + " " + last;
        String LINE13;
        LINE13 = "               " + user.firstName + " " + user.lastName;
        Stream<String> techLevel1Stream = Stream.of(LINE1, LINE7, LINE9, LINE7, LINE13, LINE7);
        techLevel1Stream.forEach(p -> System.out.println(p));
        tickets.getTicketsListLowAndMedium();
        int option = getLoginOption();
        if (option > 0) {
            tickets.getRequestedTicket(option);
            changeSeverity(option);
            changeStatus(option);
        }
    }

    public void level2Login(Technician user) {
        // String first = technicians.getFirstName(userNameTech);
        // String last = technicians.getLastName(userNameTech);
        // String techie2 = first + " " + last;

        String LINE14;
        LINE14 = "               " + user.firstName + " " + user.lastName;
        Stream<String> techLevel2Stream;
        techLevel2Stream = Stream.of(LINE1, LINE7, LINE10, LINE7, LINE14, LINE7);
        techLevel2Stream.forEach(p -> System.out.println(p));
        tickets.getTicketsListHigh();
        int option = getLoginOption();
        if (option > 0) {
            tickets.getRequestedTicket(option);
            changeSeverity(option);
            changeStatus(option);
        }
    }

    public int getLoginOption() {

        int option = 0;
        boolean isNumeric = false;
        do {
            System.out.println("Enter number of ticket to view or 0 to exit:");
            while (!scanner.hasNextInt()) {
                System.out.println("That is not a valid number, Please enter again");
                scanner.next();
            }
            isNumeric = true;
            option = scanner.nextInt();
            scanner.nextLine();

        } while (isNumeric == false);
        return option;
    }

    public void changeSeverity(int ticketOption) {
        System.out.println("Do you want to change the severity of the ticket?");
        String option = getSubmit();
        if (option.equalsIgnoreCase("Y")) {
            
            String severity = null;
            do {
                System.out.println("Enter 'L' for LOW,  'M' for MEDIUM OR 'H' for HIGH");
                System.out.print("Severity: ");
                severity = scanner.nextLine();
            } while (!severity.equalsIgnoreCase("L") && !severity.equalsIgnoreCase("M") && !severity.equalsIgnoreCase("H"));
            if (tickets.setTicketSeverity(ticketOption, severity)){
                cereal.writeTicketFile(tickets);
                System.out.println("Severity has been set.");
            } else {System.out.println("Severity has not been set.");}
            if (tickets.setTechUserName(ticketOption)) {
                cereal.writeTicketFile(tickets);
                System.out.println("Technical Username has been set.");
            } else {System.out.println("Technical Username has not been set.");}
        }
    }

    public void changeStatus(int ticketOption) {
        System.out.println("Do you want to set the status of this ticket to closed?");
        String option = getSubmit();
        if (option.equalsIgnoreCase("Y")) {
            if (tickets.closeRequestedTicket(ticketOption)){
                cereal.writeTicketFile(tickets);
                System.out.println("This ticket has been closed.");
            } else {System.out.println("Ticket was not closed.");}
        }
    }

    /**
     * Submit can only be Y or N
     *
     * @return
     */
    public String getSubmit() {

        String submitAnswer = null;
        do {
            System.out.println("Enter Y for YES or N for NO");
            submitAnswer = scanner.nextLine();
        } while (!submitAnswer.equalsIgnoreCase("Y") && !submitAnswer.equalsIgnoreCase("N"));

        return submitAnswer;
    }

    /**
     * Format the Techmenu This will now display the number of tickets outstanding
     * Name of the technician If no technician found the name will be blank
     */
    public void formatTechMenu(Technician user) {
        // the number of spaces in line 11 after displaying 1 digit is
        int spacesLine11 = 12;
        int spacesLine12 = 21;

        numOpenTickets = tickets.getNumberOpenTickets();
        // String first = technicians.getFirstName(userNameTech);
        // String last = technicians.getLastName(userNameTech);
        // String techname = first + " " + last;

        String spaceL11 = getSpaceLeft(spacesLine11, numOpenTickets);
        String spaceL12 = getSpaceLeft(spacesLine12, user.userName.length());
        String LINE11 = "|           NUMBER OF OPEN TICKETS: " + numOpenTickets + spaceL11 + "|";
        String LINE12 = "|                " + user.firstName.toUpperCase() + " " + user.lastName.toUpperCase() + spaceL12 + "|";
        Stream<String> techMenuStream = Stream.of(LINE1, LINE2, LINE3, LINE4, LINE12, LINE4, LINE11, LINE4, LINE5,
                LINE6, LINE8, LINE4, LINE1);
        techMenuStream.forEach(p -> System.out.println(p));
    }
}
