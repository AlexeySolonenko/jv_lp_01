package com.jv_lp_01;

import javax.swing.plaf.DimensionUIResource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {
        Direction n = new Direction();
        n.dirs.add("N");
        n.dirs.add("North");
        n.dirs.add("Nord");

        Direction s = new Direction();
        s.dirs.add("S");
        s.dirs.add("South");
        s.dirs.add("Sut");

        Direction w = new Direction();
        w.dirs.add("W");
        w.dirs.add("West");
        w.dirs.add("Oust");

        Direction e = new Direction();
        e.dirs.add("E");
        e.dirs.add("East");
        e.dirs.add("Orient");

        Scanner scanner = new Scanner(System.in);

        Map<Direction, Integer> tempExit = new HashMap<Direction, Integer>();
        tempExit.put(w, 2);
        tempExit.put(e, 3);
        tempExit.put(s, 4);
        tempExit.put(n, 5);
        locations.put(1, new Location(1, "You are standing at the end of the road before a small brik building",tempExit));
        //tempExit.put("Q",0);

        tempExit = new HashMap<Direction, Integer>();
        tempExit.put(n, 5);
        locations.put(2, new Location(2, "You are the top of a hill",tempExit));

        ///tempExit.put("Q",0);

        tempExit = new HashMap<Direction, Integer>();
        tempExit.put(w, 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring",tempExit));

        //tempExit.put("Q",0);

        tempExit = new HashMap<Direction, Integer>();
        tempExit.put(n, 1);
        tempExit.put(w, 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream",tempExit));

        //tempExit.put("Q",0);

        tempExit = new HashMap<Direction, Integer>();
        tempExit.put(s, 1);
        tempExit.put(w, 2);
        locations.put(5, new Location(5, "You are in the forest",tempExit));

        tempExit = new HashMap<Direction, Integer>();
        locations.put(0, new Location(0, "You are sitting in fron of the computer learning Java",tempExit));



        //locations.get(5).addExit("Q",0);

        /* !!!! LECTURE SOLUTION IS SIMPLE - AN EXTRA HASHMAP MAPING ALL VALS TO SAME ENTRIES */

        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                break;
            }
            Map<Direction, Integer> exits = locations.get(loc).getExits();
            System.out.println("Available exits are: ");
            for (Direction dir : exits.keySet()) {
                for (String exit : dir.dirs) {
                    System.out.print(exit + ", ");
                }
            }
            System.out.println();
            int tempLoc = -1;
            Direction direction = null;
            String[] userInput = scanner.nextLine().toUpperCase().split(" ");
            for (String cmd : userInput) {
                for (Map.Entry<Direction, Integer> entry : exits.entrySet()) {
                    for (String key : entry.getKey().dirs) {
                        if (cmd.equals(key.toUpperCase())) {
                            tempLoc = entry.getValue();
                            break;
                        }
                    }
                }
            }
            if (tempLoc >= 0) {
                loc = tempLoc;
            } else {
                System.out.println("You cannot go in that direction");
            }

        }


    }
}
