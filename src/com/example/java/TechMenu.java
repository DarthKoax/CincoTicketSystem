package com.example.java;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class TechMenu {
    Scanner scanner = new Scanner(System.in);

    public static final String LINE1 = "-------------------------------------------------";
    public static final String LINE2 = "|          CINCO  TICKET ISSUING SYSTEM         |";
    public static final String LINE3 = "|                TECHNICIAN USER                |";
    public static final String LINE4 = "|                                               |";
    public static final String LINE5 = "|           1.  LEVEL 1 SERVICE DESK            |";
    public static final String LINE6 = "|           2.  LEVEL 2 SERVICE DESK            |";
    public static final String LINE7 = "";
    public static final String LINE8 = "|           3.      EXIT SYSTEM                 |";

    public String loginOption;

    Stream<String> techMenuStream = Stream
            .of(new String[] { LINE1, LINE2, LINE3, LINE4, LINE5, LINE6, LINE8, LINE4, LINE1 });

    public void printTechMenu() {
        techMenuStream.forEach(p -> System.out.println(p));
        System.out.println("Enter number for Service desk or Option 3 to Exit");
        loginOption = getServiceDesk();
        validateLogin(loginOption);
    }

    public String getServiceDesk() {
        String level = null;
        do {
            System.out.println("You can only enter option '1' , '2' ,'3'");
            level = scanner.nextLine();

        } while (!level.equals("1") && !level.equals("2") && !level.equals("3"));
        return level;
    }

    public void validateLogin(String loginOption) {
        switch (loginOption) {
        case "1":
            System.out.println("go to helpdesk 1");
            break;
        case "2":
            System.out.println("go to helpdesk 2");
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
