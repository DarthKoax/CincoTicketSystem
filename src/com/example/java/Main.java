package com.example.java;


import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        // Run Tests with -ea at runtime.
        Tests tests = new Tests();
        tests.testTicket();
        tests.testTicketOpen();
        tests.testTicketClosed();
        // end of tests

        // when main start load list of technicians
        // Technician technician = new Technician();
        loadTechnicians();
        seedTickets();

        SerializeList cereal = new SerializeList();
        TicketList tickets = cereal.readTicketFile();
        //Check all tickets for dates and close those which are 7+ days old. 
        tickets.ClearOutOfDate();
        cereal.writeTicketFile(tickets);

   
        /**
         * Will prompt user to enter information to create IT Issue ticket
         */
        // Scanner scanner = new Scanner(System.in);
        String LINE1 = "--------------------------------------------------------";
        String LINE2 = "|          LOGIN CINCO  TICKET ISSUING SYSTEM          |";
        String LINE3 = "|                                                      |";
        String LINE4 = "|               1.     STAFF USER                      |";
        String LINE5 = "|               2.     TECHNICIAN USER                 |";
        String LINE6 = "";
        String LINE7 = "|               3.     EXIT SYSTEM                     |";
        String LINE8 = "|                      LOGIN                           |";

        while (true) {
            // build then output main menu.
            Stream<String> mainMenuStream = Stream.of(new String[]{LINE1, LINE3, LINE2, LINE3, LINE8, LINE3, LINE1});

            mainMenuStream.forEach(p -> System.out.println(p));
            // System.out.print("Make a selection...");
            String selection;
            Login login = new Login();
            Technician currentUser = login.SystemLogin();

            // get valid user selection
            do {
                if (currentUser instanceof Technician) {
                    selection = "2";
                } else {
                    selection = "1";
                }
            } while (!selection.equals("1") && !selection.equals("2") && !selection.equals("3"));

            switch (selection) {
                case "1":
                    UserMenu usermenu = new UserMenu();
                    usermenu.printUserMenu();
                    break;
                case "2":
                    TechMenu techmenu = new TechMenu();
                    techmenu.printTechMenu(currentUser);
                    break;
                case "3":
                    System.out.println("Exit the system ");
                    System.exit(0);
                    // scanner.close();
                    break;
                default:
                    System.out.println("Something went very wrong");
            } // switch
        } // While loop

    }

    // load the technicians when the main starts
    public static void loadTechnicians() {
        SerializeList cereal = new SerializeList();
        TechnicianList technicians = cereal.readTechnicianFile();

        if (technicians.size() == 0) {

            Technician harry = new Technician("Harry", "Styles", "harry.styles", "1");
            Technician niall = new Technician("Niall", "Horan", "niall.horan", "1");
            Technician liam = new Technician("Liam", "Payne", "liam.payne", "1");
            Technician louis = new Technician("Louis", "Tomlinsonand", "louis.tomlinsonand", "2");
            Technician zayn = new Technician("Zayn", "Malik", "zayn.malik", "2");

            technicians.add(harry);
            technicians.add(niall);
            technicians.add(liam);
            technicians.add(louis);
            technicians.add(zayn);
            cereal.writeTechnicianFile(technicians);
        }

    }

    public static void seedTickets() {
        SerializeList cereal = new SerializeList();
        TicketList tickets = cereal.readTicketFile();

        if (tickets.size() == 0) {

            
            Ticket ticket1 = new Ticket("Bob", "Brown", "5555", "bob.brown@cinco.com", "044555787", "No network connection", "HIGH","open", 2019,11-1,12);
            tickets.add(ticket1);
            cereal.writeTicketFile(tickets);  
            
            Ticket ticket2 = new Ticket("Frank", "Buster", "6578", "Frank.Buster@cinco.com", "04457558", "Computer wont turn on", "LOW","open", 2019,9,12);
            tickets.add(ticket2);
            cereal.writeTicketFile(tickets);
        }

    }

}
