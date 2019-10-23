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

    public int loginOption;


    Stream<String> techMenuStream = Stream.of(new String[]{LINE1, LINE3, LINE2, LINE3, LINE4,LINE3, LINE5, LINE3, LINE3,LINE1,LINE3});

    public void printTechMenu() {
        techMenuStream.forEach(p -> System.out.println(p));
        System.out.println("Enter number for Service desk ");
        loginOption = scanner.nextInt();
        scanner.nextLine();
    }
}
