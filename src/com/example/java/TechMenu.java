package com.example.java;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class TechMenu {
    Scanner scanner = new Scanner(System.in);
    public static final String LINE1   = "-------------------------------------------------------------";
    public static final String LINE2   = "|              CINCO  TICKET ISSUING SYSTEM                  ";
    public static final String LINE3   = "|                                                            ";
    public static final String LINE4   = "|                1. LEVEL 1 SERVICE DESK                     ";
    public static final String LINE5   = "|                2. LEVEL 2 SERVICE DESK                     ";
    public static final String LINE6   = "";
    public static final String LINE7   = "|                3. EXIT SYSTEM                              ";

    public String loginOption;


    Stream<String> techMenuStream = Stream.of(new String[]{LINE1, LINE3, LINE2, LINE3, LINE4,LINE3, LINE5, LINE3,LINE7, LINE3,LINE1,LINE6});

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
            System.out.print("Severity: ");
            level = scanner.nextLine();

        } while (!level.equals("1")&&!level.equals("2")&&!level.equals("3"));
        return level;
    }

    public void validateLogin(String loginOption) {
        switch(loginOption) {
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
