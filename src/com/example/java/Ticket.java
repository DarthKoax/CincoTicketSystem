package com.example.java;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;


public class Ticket implements Serializable {
    public String firstName;
    public String lastName;
    public String staffNumber;
    public String submitTicket;
    public String email;
    public String contact;
    public String description;
    public String severity;
    public String status;
    public int id;
    public String techUserName;

    
    public Calendar date;

    SerializeList cereal = new SerializeList();
    TicketList tickets = cereal.readTicketFile();
    ArrayList<Technician> technicians = new ArrayList<Technician>();

    transient Scanner scanner = new Scanner(System.in);

    public Ticket() {
        status = "open";
    }

    public Ticket(String firstName, String lastName, String staffNumber, String email, String contact, String description, String severity, String status, int id, String techUserName) {
        this.status = status;
        this.firstName = firstName;
        this.lastName = lastName;
        this.staffNumber = staffNumber;
        this.email = email;
        this.contact = contact;
        this.description = description;
        this.severity = severity;
        this.id = id;
        this.techUserName = techUserName;
        
        this.date = Calendar.getInstance();
    }

    public Ticket(String firstName, String lastName, String staffNumber, String email, String contact, String description, String severity, String status, int id,int year, int month, int day) {
        this.status = status;
        this.firstName = firstName;
        this.lastName = lastName;
        this.staffNumber = staffNumber;
        this.email = email;
        this.contact = contact;
        this.description = description;
        this.severity = severity;
        this.id = tickets.getLastId();
        
        this.date = Calendar.getInstance();
        this.date.set(year,month,day);
    }

    public boolean getTicketInput() {
        boolean submission = false;
        
        techUserName = "";
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

        // date = new Date(System.currentTimeMillis());
        date = Calendar.getInstance();
        System.out.println(date.getTime());

        System.out.println("Severity can only have values of low, medium or high");

        severity = getSeverityUser();
        if (severity.equalsIgnoreCase("L")) {
            severity = "LOW";
        } else if (severity.equalsIgnoreCase("M")) {
            severity = "MEDIUM";
        } else if (severity.equalsIgnoreCase("H")) {
            severity = "HIGH";
        }

        System.out.println("DO you want to submit the form? ");
        submitTicket = getSubmit();
        if (submitTicket.equalsIgnoreCase("Y")) {
            id = tickets.getLastId();
            techUserName = getTech(severity);
            submission = true;
            System.out.println("Ticket submitted");
        } else {
            System.out.println("Ticket will not be submitted");
        }
        return submission;
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
     * Severity can only have a status of low, medium or high
     *
     * @return
     */
    public String getSeverityUser() {
        String s = null;
        do {
            System.out.println("Enter 'L' for LOW,  'M' for MEDIUM OR 'H' for HIGH");
            System.out.print("Severity: ");
            s = scanner.nextLine();
        } while (!s.equalsIgnoreCase("L") && !s.equalsIgnoreCase("M") && !s.equalsIgnoreCase("H"));
        return s;
    }

    public String toString() {
        String objectString = "Ticket\n=======\n";
        objectString += "First name: " + this.firstName + ", \n";
        objectString += "Last name: " + this.lastName + ", \n";
        objectString += "Staff number: " + this.staffNumber + ", \n";
        objectString += "Email: " + this.email + ", \n";
        objectString += "Contact: " + this.contact + ", \n";
        objectString += "Description: " + this.description + ", \n";
        objectString += "Severity Level: " + this.severity + ", \n";
        objectString += "Status: " + this.status + "\n";
        objectString += "ID: " + this.id + "\n";
        objectString += "TechUserName: " + this.techUserName + "\n";
        return objectString;
    }

    // displays the list of open tickets for the specific Technical level
    public String listTickets()
    {
       if (getStatus().equalsIgnoreCase("OPEN"))
       {
          String lt = "ID: " + this.id;
    	  {
             lt += "   Description: " + String.format("%.15s", this.description) + ", \n";
             lt += "   Severity Level: " + this.severity;
             lt += "   Status: " + this.status + "\n";
          }
    	  return lt;
       }	
       return "";
    }
    
    // displays the list of closed tickets
    public String archivedTickets() {
        String at = "ID: " + this.id;
        at += "   Description: " + String.format("%.15s", this.description) + ", \n";
        at += "   Severity Level: " + this.severity;
        at += "   Status: " + this.status + "\n";
        return at;
    }

    public String getTech(String severity) {
        String techName = null;
        techName = tickets.getTechName(severity);
        return techName;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStaffNumber() {
        return staffNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getSubmitTicket() {
        return submitTicket;
    }

    public String getContact() {
        return contact;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getSeverity() {
        return severity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSeverityHigh(){
        this.severity = "HIGH";
    }

    public void setSeverityMedium(){
        this.severity = "MEDIUM";
    }

    public void setSeverityLow(){
        this.severity = "LOW";
    }

    public void setStatusOpen(){
        this.status = "open";
    }

    public void setStatusClosed(){
        this.status = "closed";
    }

    public String getTechUserName() {
        return techUserName;
    }

    public void setTechUserName(String techUserName) {
        this.techUserName = techUserName;
    }
}
