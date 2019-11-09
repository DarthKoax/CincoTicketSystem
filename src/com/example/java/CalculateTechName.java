package com.example.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CalculateTechName {
    SerializeList cereal = new SerializeList();

    TechnicianList technicians = cereal.readTechnicianFile();
    TicketList tickets = cereal.readTicketFile();

    private static final long serialVersionUID = 1L;

    private Random randomGenerator = new Random();
    String technameReturn = null;


    boolean possibleEqualCount = false;
    int equalCount = 0;


    /**
     * Loop through a list of all the tickets to determine the number of tickets already assigned to each user
     * Cycle through countsTech to determine the technician with the lowest number of tickets
     * is there are more than 1 technical user with the same number of tickets then assign the user randonly
     * Could not just call calcLevel1Technician for you might have only 2 users with the same number of tickets
     * assigned and cant randomly assign to the whole set of users.
     *
     * @return
     */
    public String calcTechUser(String s) {
        int tNumTickets = 0;
        String tName = "";
        Map<String, Integer> countsTech = new HashMap<String, Integer>();
        ArrayList<String> techNameList = new ArrayList<>();
        techNameList.clear();

        // initialises the technical users ticket count based on severity of current ticket being raised
        if (technicians != null && !technicians.equals("")) {
            if (s.equalsIgnoreCase("HIGH")) {
                for (Technician tech : technicians) {
                    if (tech.level.equals("2")) {
                        countsTech.put(tech.userName, 0);
                    }
                }
            } else {
                for (Technician tech : technicians) {
                    if (tech.level.equals("1")) {
                        countsTech.put(tech.userName, 0);
                    }
                }
            }

        }

        // loop through tickets and add 1 to each ticket for current severity level found in ticketlist
        if (tickets != null && !(tickets.size() == 0)) {
            for (Ticket t : tickets) {
                for (Map.Entry<String, Integer> tu1 : countsTech.entrySet()) {
                    if (tu1.getKey().equalsIgnoreCase(t.getTechUserName())) {
                        countsTech.replace((t.getTechUserName()), tu1.getValue() + 1);
                    }
                }
            }
        }

        /**
         * Need to know which technical user has the lowest ticket or is technical users have equal amount of tickets
         * first time gets executed save the first technical user and number of tickets for tech in tname and tNumTickets
         * tname and tNumTickets should always contain the technical username with the lowest num of tickets
         * if there are users with equal tickets set possibleEqualCount to true
         * if possibleEqualCount = true and a user with lower number of tickets come in possibleEqualCount set to false again
         */
        for (Map.Entry<String, Integer> tu : countsTech.entrySet()) {
            if (tName.equals("")) {
                tName = tu.getKey();
                tNumTickets = tu.getValue();

            } else {
                if (tu.getValue() < tNumTickets) {
                    tName = tu.getKey();
                    tNumTickets = tu.getValue();
                    if (possibleEqualCount) {
                        possibleEqualCount = false;
                        techNameList.clear();
                        equalCount = 0;
                    }
                } else {
                    if (tu.getValue() == tNumTickets) {
                        if (!possibleEqualCount) {
                            techNameList.add(tName);
                            techNameList.add(tu.getKey());
                            possibleEqualCount = true;
                            equalCount = tNumTickets;
                        } else {
                            techNameList.add(tu.getKey());
                        }
                    }
                }
            }   // end of if else
        }   // end of for loop
        if (possibleEqualCount) {
            int index = randomGenerator.nextInt(techNameList.size());
            technameReturn = techNameList.get(index);
        } else {
            technameReturn = tName;
        }

        return technameReturn;
    }

    /**
     * Assign Randomly a level1 technician
     *
     * @return
     */
    public String calcLevel1Technician() {
        ArrayList<String> techNameList = new ArrayList<>();
        techNameList.clear();
        if (technicians != null && !technicians.equals("")) {
            for (Technician t : technicians) {
                if (t.level.equals("1")) {
                    techNameList.add(t.userName);
                }
            }
            int index = randomGenerator.nextInt(techNameList.size());
            technameReturn = techNameList.get(index);
        } else {
            System.out.println("Something went horribly wrong with the main load for technicians for there are no technicians defined");
        }
        return technameReturn;
    }

    /**
     * Assigns Randomly a level2 technician, determine from technicians what level tech is
     *
     * @return
     */
    public String calcLevel2Technician() {
        ArrayList<String> techNameList = new ArrayList<>();
        techNameList.clear();
        if (technicians != null && !technicians.equals("")) {
            for (Technician t : technicians) {
                if (t.level.equals("2")) {
                    techNameList.add(t.userName);
                }
            }
            int index = randomGenerator.nextInt(techNameList.size());
            technameReturn = techNameList.get(index);
        } else {
            System.out.println("Something went horribly wrong with the main load for technicians for there are no technicians defined");
        }
        return technameReturn;
    }
}
