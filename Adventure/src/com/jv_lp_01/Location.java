package com.jv_lp_01;

import java.util.HashMap;
import java.util.Map;

public class Location {

    private final int locationID;
    private final String description;
    private final Map<Direction, Integer> exits;

    public Location(int locationID, String description, Map<Direction,Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        //this.exits = new HashMap<Direction,Integer>();
        Direction q = new Direction();
        q.dirs.add("Quit");
        q.dirs.add("Exit");
        q.dirs.add("Q");
        HashMap<Direction, Integer> tempExits = new HashMap<Direction, Integer>();
        if(exits != null){
            tempExits = new HashMap<Direction, Integer>(exits);
        }

        tempExits.put(q,0);
        this.exits = tempExits;
       // this.exits.put(q,0);
    }

//    public void addExit(Direction direction, int location){
//        exits.put(direction,location);
//    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<Direction, Integer> getExits() {
        /* !! RETURN a shallow copy, not the references */
        return new HashMap<Direction, Integer>(exits);
    }
}
