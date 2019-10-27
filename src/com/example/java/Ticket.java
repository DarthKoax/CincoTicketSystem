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
    public String status;

    Scanner scanner = new Scanner(System.in);

    public Ticket(){status = "open";}
    
    public Ticket(String firstName, String lastName, String staffNumber, String email, String contact, String description, String severity, String status){
        this.status = status;
        this.firstName = firstName;
        this.lastName = lastName;
        this.staffNumber = staffNumber;
        this.email = email;
        this.contact = contact;
        this.description = description;
        this.severity = severity;
    }

    public boolean getTicketInput() {
        boolean submission = false;
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

        severity = getSeverity();

        System.out.println("DO you want to submit the form? ");
        submitTicket = getSubmit();
        if (submitTicket.equalsIgnoreCase("Y")) {
            submission = true;
            System.out.println("Ticket submitted");
        } else {
            System.out.println("Ticket will not be submitted");
        }
        return submission;
    }


    /**
     * Submit can only be Y or N
     * @return
     */
    public String getSubmit() {
        String submitAnswer = null;
        do {
            System.out.println("Enter Y for YES or N for NO");
            submitAnswer = scanner.nextLine();
        } while (!submitAnswer.equalsIgnoreCase("Y")&&!submitAnswer.equalsIgnoreCase("N"));
        return submitAnswer;
    }


    /**
     * Severity can only have a status of low, medium or high
     * @return
     */
    public String getSeverity() {
      String s = null;
      do {
          System.out.println("Enter 'L' for LOW,  'M' for MEDIUM OR 'H' for HIGH");
          System.out.print("Severity: ");
          s = scanner.nextLine();
      } while (!s.equalsIgnoreCase("L")&&!s.equalsIgnoreCase("M")&&!s.equalsIgnoreCase("H"));
      return s;
    }

    public String toString(){
        String objectString = "";
        objectString += this.firstName +"/t"+ this.lastName +"/t"+ this.staffNumber +"/t"+ this.email+"/t";
        objectString += this.contact +"/t"+ this.description +"/t"+ this.severity +"/t"+ this.status+"/n";

        return objectString;
    }
}
