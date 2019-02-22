package com.jv_lp_01;

public class Main {

    public static void main(String[] args) {
	    FootballTeam real = new FootballTeam("Real");
	    FootballTeam bc = new FootballTeam("bc");
	    FootballTeam dinamo = new FootballTeam("Dynamo");
	    FootballTeam chelsy = new FootballTeam("Chelsy");

	    HockeyTeam ru = new HockeyTeam("ru");
	    HockeyTeam en = new HockeyTeam("en");
	    HockeyTeam sw = new HockeyTeam( "sw");

	    League<FootballTeam> footbLeague = new League<FootballTeam>("Footbal League");
	    footbLeague.addTeam(real);
	    footbLeague.addTeam(bc);
	    footbLeague.addTeam(dinamo);
	    footbLeague.addTeam(chelsy);
	    //footbLeague.addTeam(ru);
        real.setScore(1);
        bc.setScore(10);
        dinamo.setScore(7);
        chelsy.setScore(5);
        footbLeague.printScores();
    }
}
