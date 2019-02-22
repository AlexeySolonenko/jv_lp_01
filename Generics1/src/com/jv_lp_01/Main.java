package com.jv_lp_01;

import com.sun.source.tree.Scope;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        /* raw type , no type - this is the old type ,left for backwards compatibility */
        //ArrayList items = new ArrayList();
        ArrayList<Integer> items = new ArrayList<>();
        items.add(1);
        items.add(2);
        items.add(3);
        //items.add("tim");
        items.add(4);
        items.add(5);
        printDouble(items);


        FootbalPlayer joe= new FootbalPlayer("Joe");
        BasebalPlayer pat = new BasebalPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team<FootbalPlayer> adelaideCrows = new Team<FootbalPlayer>("Adelaide Crows");
        adelaideCrows.addPlayer(joe);
        //adelaideCrows.addPlayer(pat);
        //adelaideCrows.addPlayer(beckham);

        System.out.println(adelaideCrows.numPlayser());

        Team<BasebalPlayer> baseBalTeam = new Team<>("Chicago Cubs");
        baseBalTeam.addPlayer(pat);

        /* what about */
        //Team<String > brokenTeam = new Team("this won't work");
        //brokenTeam.addPlayer("no-one");
        Team<SoccerPlayer> soccerTeam = new Team<>("Dinamo");
        soccerTeam.addPlayer(beckham);

        Team<FootbalPlayer> melbourne = new Team<>("Melbourne");
        FootbalPlayer banks = new FootbalPlayer("Gordon");
        melbourne.addPlayer(banks);

        Team<FootbalPlayer> hawthorn = new Team<>("Hawthorn");
        Team<FootbalPlayer> fremantle = new Team<>("Fremantle");

        hawthorn.matchResult(fremantle, 1, 0);
        hawthorn.matchResult(adelaideCrows, 3, 8);

        adelaideCrows.matchResult(fremantle,2,1);
        //adelaideCrows.matchResult(baseBalTeam,1,1);

        System.out.println("Rankings");
        System.out.println(adelaideCrows.getName() + ": " + adelaideCrows.ranking());
        System.out.println(melbourne.getName() + ": " + melbourne.ranking());
        System.out.println(fremantle.getName() + ": " + fremantle.ranking());
        System.out.println(hawthorn.getName() + ": " + hawthorn.ranking());

        System.out.println(adelaideCrows.compareTo(melbourne));
        System.out.println(adelaideCrows.compareTo(hawthorn));
        System.out.println(hawthorn.compareTo(adelaideCrows));
        System.out.println(melbourne.compareTo(fremantle));

        ArrayList<Team> teams = new ArrayList<Team>();
        teams.add(melbourne);

        Collections.sort(teams);


    }

    private static void printDouble(ArrayList<Integer> n) {
        //for (Object i : n) {
        for (int i : n) {
            //System.out.println((Integer) i + 2);
            System.out.println( i + 2);
        }
    }


}
