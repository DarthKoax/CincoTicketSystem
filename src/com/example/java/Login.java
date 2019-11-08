package com.example.java;

import java.util.Scanner;

public class Login {
   Scanner input = new Scanner(System.in);

   public Login() {
   };

   public Technician SystemLogin() {

      String userName;
      String password;
      Technician nullTech = null;
      
      // System.out.println("Note: Type 'exit' to quit the program");
      SerializeList cereal = new SerializeList();

      System.out.println("Enter Username: ");
      userName = input.nextLine();

      System.out.println("Enter Password: ");
      password = input.nextLine();

      // System.out.println("| |");
      System.out.println("-------------------------------------------------");

      TechnicianList technicians = cereal.readTechnicianFile();
      for (Technician tech : technicians) {

         if (userName.equals(tech.userName)) {
            return tech;
         }
      }
      

      return nullTech;

   }
}
