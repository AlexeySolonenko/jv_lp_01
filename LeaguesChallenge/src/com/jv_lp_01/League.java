package com.jv_lp_01;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team>  {

    private String name;
    private ArrayList<T> teams = new ArrayList<T>();



    // region GETTERS AND SETTERS

    public League(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addTeam(T team){
        if(teams.contains(team)){
            System.out.println(team.getName() + " is already in the league");
        } else {
            teams.add(team);
            System.out.println(team.getName() + " added to league " + this.name);
        }
    }


    public void printScores(){
        Collections.sort(this.teams);
        Collections.reverse(this.teams);
        System.out.println("\n" + this.name + "scores: ");
        for(Team t: this.teams){
            System.out.println(t.getName()+ ": " + t.getScore());
        }

    }



    // endregion GETTERS AND SETTERS
}
