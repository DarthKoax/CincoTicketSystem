package com.example.java;

public class Main {


    public static void main(String[] args) {

        /**
         *  Will prompt user to enter information to create IT Issue ticket
         */
        Ticket ticket = new Ticket();
        ticket.getTicketInput();

        TechMenu techmenu = new TechMenu();
        techmenu.printTechMenu();
    }
}
