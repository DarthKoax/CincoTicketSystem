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

    //Strings for Main Menu
    public static final String LINE1 = "-------------------------------------------------";
    public static final String LINE2 = "|          CINCO  TICKET ISSUING SYSTEM         |";
    public static final String LINE3 = "|                TECHNICIAN USER                |";
    public static final String LINE4 = "|                                               |";
    //public static final String LINE5 = "|           1.  LEVEL 1 SERVICE DESK            |";
    public static final String LINE5 = "|           1.  ASSIGNED TICKETS                |";
    //public static final String LINE6 = "|           2.  LEVEL 2 SERVICE DESK            |";
    public static final String LINE6 = "|           2.  ARCHIVED TICKETS                |";
    public static final String LINE7 = "";
    public static final String LINE8 = "|           3.  LOG OUT                         |";
    //public static final String LINE9 = "               LEVEL 1 SERVICE DESK TICKETS    ";
    public static final String LINE9 = "               ASSIGNED TICKETS                ";
    //public static final String LINE10 = "               LEVEL 2 SERVICE DESK TICKETS    ";
    public static final String LINE15 = "           ARCHIVED TICKETS                    ";    

    //String Variables for menu choice and logged in Technician 
    public String loginOption;
    public String userNameTech;

    //Print the main technician menu 
    public void printTechMenu(Technician currentUser) {

        while (true) {
            formatTechMenu(currentUser);

            loginOption = getServiceDesk();
            validateLogin(loginOption, currentUser);
        }
    }

    //get the user menu choice input
    public String getServiceDesk() {
        String level = null;
        do {
            System.out.println("You can only enter option '1', '2', '3'");
            level = scanner.nextLine();

        //} while (!level.equals("1") && !level.equals("2") && !level.equals("3") && !level.equals("99"));
        } while (!level.equals("1") && !level.equals("2") && !level.equals("3"));
    return level;
    }

    //Launch the functions for each menu choice
    public void validateLogin(String loginOption, Technician tech) {
        switch (loginOption) {
        case "1":
            //ASSIGNED TICKETS()
            assignedTickets(tech);
            break;
        case "2":
            //ARCHIVED TICKETS()
            displayArchivedTickets(tech);
            break;
        case "3":
        	System.out.println("Exit the system ");
            System.exit(0);
            break;
       /** 
        case "99":
        //This menu item will display each technician and their assigned ticket IDs
            System.out.println("SUPER SECRET MENU ITEM: ");
            whoHasWhat();
            break;
        */
        default:
            System.out.println(loginOption);
            System.out.println("Something went very wrong");
        }
    }

    //Function to aid in building strings
    public String getSpaceLeft(Integer sl, Integer num) {
        int spaceLength = sl;
        int numL = String.valueOf(num).length();
        int count = sl - numL;
        String spaceCalc = String.format("%" + count + "c", ' ');
        return spaceCalc;
    }

    //Menu Item calls this function to run through displaying and changing tickets assigned to 
    //  the current technician.
    //This function calls a TicketList function which prints out each ticket (in a condensed form) 
    //  with the ID that matches the current technician
    //The technician can select a ticket to view in detail.
    //The Technician has the choice to change the severity of this ticket or close the ticket 
    //  or do neither.
    public void assignedTickets(Technician user) {

        String LINE13;
        LINE13 = "               " + user.firstName + " " + user.lastName;
        Stream<String> assignedTicketStream = Stream.of(LINE1, LINE7, LINE9, LINE7, LINE13, LINE7);
        assignedTicketStream.forEach(p -> System.out.println(p));
        tickets.getTicketsListTechnician(user.getUserName());
        int option = getLoginOption();
        if (option > 0) {
            if(tickets.getRequestedTicket(option,user.getUserName())){
                if(changeSeverity(option)){}
                else{
                    changeStatus(option);    
                }
            }
        }
    } 
    
    //Superceded menu options to print out level 1 or level 2 tickets
    /**
    public void level1Login(Technician user) {

        // String first = technicians.getFirstName(userNameTech);
        // String last = technicians.getLastName(userNameTech);
        // String techie1 = first + " " + last;
        String LINE13;
        LINE13 = "               " + user.firstName + " " + user.lastName;
        Stream<String> techLevel1Stream = Stream.of(LINE1, LINE10, LINE8, LINE13, LINE8);
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
        techLevel2Stream = Stream.of(LINE1, LINE11, LINE8, LINE14, LINE8);
        techLevel2Stream.forEach(p -> System.out.println(p));
        tickets.getTicketsListHigh();
        int option = getLoginOption();
        if (option > 0) {
            tickets.getRequestedTicket(option);
            changeSeverity(option);
            changeStatus(option);
        }
    }
    **/

    //Function to display all closed tickets in a condensed format
    //Using a TicketList function, the technician can enter a ticketId to view that ticket in detail.
    public void displayArchivedTickets(Technician user)
    {
        String LINE13 = "               " + user.firstName + " " + user.lastName;
        Stream<String> techLevel1Stream = Stream.of(LINE1, LINE15, LINE4, LINE13, LINE4);
        techLevel1Stream.forEach(p -> System.out.println(p));
        tickets.getArchivedTicket();
        int option = getLoginOption();
        if (option > 0) {
            tickets.getRequestedClosedTicket(option);
        }
    }

    //This function is used in the secret menu item to call TicketList function that prints out 
    //  each technician's name along with each ticketId assigned to them
    //This function is disabled in the release
    public void whoHasWhat(){
        tickets.ticketsPerTechnician();
    }

    //This function gets the user input for selecting a ticket by ticketId
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

    //This function is called after viewing an assigned ticket in detail.
    //The technician can choose to change the severity of a ticket, in which case the ticket is 
    //  reassigned to a technician of the correct level.
    public boolean changeSeverity(int ticketOption) {
        System.out.println("Do you want to change the severity of the ticket?");
        String option = getSubmit();
        boolean opt = false;
        if (option.equalsIgnoreCase("Y")) {
            opt = true;
            String severity = null;
            do {
                System.out.println("Enter 'L' for LOW,  'M' for MEDIUM OR 'H' for HIGH");
                System.out.print("Severity: ");
                severity = scanner.nextLine();
            } while (!severity.equalsIgnoreCase("L") && !severity.equalsIgnoreCase("M") && !severity.equalsIgnoreCase("H"));
            if (tickets.setTicketSeverity(ticketOption, severity)){
                cereal.writeTicketFile(tickets);
                System.out.println("Severity has been set.");
                //if Severity has been set, then set a new technician
                //but first set this ticket's techUserName to blank so it is not included in the count
                if (tickets.setTechUserNameBlank(ticketOption)){
                    cereal.writeTicketFile(tickets);
                    //System.out.println("Technician removed from ticket.");
                } //else {System.out.println("Technician not excluded from count");}
                if (tickets.setTechUserName(ticketOption)) {
                    cereal.writeTicketFile(tickets);
                    System.out.println("Technical Username has been set.");
                } else {System.out.println("Technical Username has not been set.");}
            } else {System.out.println("Severity has not been set.");}

            if (tickets.setTechUserName(ticketOption)) {
                cereal.writeTicketFile(tickets);
                System.out.println("Technical Username has been set.");
            } else {System.out.println("Technical Username has not been set.");}
   
           }
        return opt;
 
    }

    //This function is called after a technician chooses not to change the severity of a ticket.
    //This function asks the technician if they would like to close the ticket 
    //  If so, a TicketList function is called which sets the ticket status to closed.  
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
        //int spacesLine11 = 12;
        int spacesLine12 = 22;
        int spacesLine13 = 8;

        numOpenTickets = tickets.getNumberAssignedTickets(user.getUserName());
        // String first = technicians.getFirstName(userNameTech);
        // String last = technicians.getLastName(userNameTech);
        // String techname = first + " " + last;

        //String spaceL11 = getSpaceLeft(spacesLine11, numOpenTickets);
        String spaceL13 = getSpaceLeft(spacesLine13, numOpenTickets);
        String spaceL12 = getSpaceLeft(spacesLine12, user.userName.length());
        String LINE11 = "|           NUMBER OF ASSIGNED TICKETS: " + numOpenTickets + spaceL13 + "|";
        String LINE12 = "|                " + user.firstName.toUpperCase() + " " + user.lastName.toUpperCase() + spaceL12 + "|";
        Stream<String> techMenuStream = Stream.of(LINE1, LINE2, LINE3, LINE4, LINE12, LINE4, LINE11, LINE4, LINE5,
                LINE6, LINE8, LINE4, LINE1);
        techMenuStream.forEach(p -> System.out.println(p));
    }
}
