package com.example.java;

import java.util.Scanner;
import java.util.stream.Stream;

public class Main {



    public static void main(String[] args) {

        // Run Tests with -ea at runtime.
        Tests tests = new Tests();
        tests.testTicket();
        tests.testTicketOpen();
        tests.testTicketClosed();
        // end of tests

        //when main start load list of technicians
        Technician technician = new Technician();
        technician.loadTechnicians();

        //SerializeList cereal = new SerializeList();

        //Testing Remove from production. 
        // Technician harry = new Technician("Harry", "Styles", "harry.styles", "1");
        // Technician niall = new Technician("Niall", "Horan", "niall.horan", "1");
        // TechnicianList technicians = new TechnicianList();
        // technicians.add(harry);
        // technicians.add(niall);
        // cereal.writeTechnicianFile(technicians);

        // TechnicianList technicians =  cereal.readTechnicianFile();
        // for(Technician tech : technicians){
        //     System.out.println(tech.firstName);
        // }

        /**
         * Will prompt user to enter information to create IT Issue ticket
         */
        Scanner scanner = new Scanner(System.in);
        String LINE1 = "--------------------------------------------------------";
        String LINE2 = "|          LOGIN CINCO  TICKET ISSUING SYSTEM          |";
        String LINE3 = "|                                                      |";
        String LINE4 = "|               1.     STAFF USER                      |";
        String LINE5 = "|               2.     TECHNICIAN USER                 |";
        String LINE6 = "";
        String LINE7 = "|               3.     EXIT SYSTEM                     |";

        // TODO: Once this menu has been changed to a login screen this will need to be
        // changed so that the user doesnt return here after going into deeper menus

        while (true) {
            // build then output main menu.
            Stream<String> mainMenuStream = Stream
                    .of(new String[] { LINE1, LINE3, LINE2, LINE3, LINE4, LINE5, LINE7, LINE3, LINE1 });

            mainMenuStream.forEach(p -> System.out.println(p));
            System.out.print("Make a selection...");
            String selection;

            // get valid user selection
            do {
                selection = scanner.nextLine();
            } while (!selection.equals("1") && !selection.equals("2") && !selection.equals("3"));

            switch (selection) {
            case "1":
                UserMenu usermenu = new UserMenu();
                usermenu.printUserMenu();
                break;
            case "2":
                TechMenu techmenu = new TechMenu();
                techmenu.printTechMenu();
                break;
            case "3":
                System.out.println("Exit the system ");
                System.exit(0);
                scanner.close();
                break;
            default:
                System.out.println("Something went very wrong");
            } // switch
        } // While loop

    }


    // load the technicians when the main starts
    public static void loadTechnicians() {
        SerializeList cereal = new SerializeList();
        TechnicianList technicians =  cereal.readTechnicianFile();
        Technician technician = new Technician();

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
        technicians.add(technician);
        cereal.writeTechnicianFile(technicians);

    }


}
