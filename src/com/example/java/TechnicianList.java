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
}


