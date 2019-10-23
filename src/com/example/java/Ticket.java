package com.example.java;

import java.util.Scanner;

public class Ticket {
    public String firstName;
    public String lastName;
    public String staffNumber;
    public String submitTicket;
    public String email;
    public String contact;
    public String description;
    public String severity;

    Scanner scanner = new Scanner(System.in);

    public void getTicketInput() {
        System.out.println("Enter the following information to create an IT Issue Ticket");
        System.out.print("First Name:  ");
        firstName = scanner.nextLine();

        System.out.print("Last Name:  ");
        lastName = scanner.nextLine();

        System.out.print("Staff Number: ");
        staffNumber = scanner.nextLine();

        System.out.print("Email: ");
        email = scanner.nextLine();

        System.out.print("Contact Number: ");
        contact = scanner.nextLine();

        System.out.print("Description: ");
        description = scanner.nextLine();

        System.out.println("Severity can only have values of low, medium or high");
        System.out.print("Severity: ");
        severity = scanner.nextLine();

        System.out.println("DO you want to submit the form Y for YES and N for NO  ");
        submitTicket = scanner.nextLine();
        if (submitTicket.equalsIgnoreCase("Y")) {

            System.out.println("Ticket submitted");
        }

    }

}
