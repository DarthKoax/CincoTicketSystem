package com.example.java;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class TechnicianList implements Serializable, Iterable<Technician> {

   private static final long serialVersionUID = 2L;
   private final ArrayList<Technician> technicians = new ArrayList<Technician>();

   public void add(Technician tech) {
      technicians.add(tech);
   }

   public int size() {
      return technicians.size();
   }

   @Override
   public Iterator<Technician> iterator() {
      return technicians.iterator();
   }


   // get technical users first name
   public String getFirstName(String techname) {
      String techFirstName = null;
      if (technicians != null && !technicians.equals("")) {
         for (Technician t : technicians) {
            if (t.getUserName().equalsIgnoreCase(techname) ) {
               techFirstName = t.getFirstName();
            }
         }
      }
      return techFirstName;
   }

   // get technical users last name
   public String getLastName(String techname) {
      String techLastName = null;
      if (technicians != null && !technicians.equals("")) {
         for (Technician t : technicians) {
            if (t.getUserName().equalsIgnoreCase(techname) ) {
               techLastName= t.getLastName();
            }
         }
      }
      return techLastName;
   }

}


