package com.jv_lp_01;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        int newScore = calculcateScore("Tim", 500);
        System.out.println("New score is " + newScore);
        calculcateScore(200);
        Optional<String> n = Optional.of("Bob");
        calculcateScore(200, n);
        //calculcateScore(200,(new Optional<String>("Bob")).of("Bob"));
    }

    public static int calculcateScore(String playerName, int score) {
        System.out.println("Player " + playerName + " scored " + score + " points.");
        return score * 1000;
    }

    public static int calculcateScore(int score) {
        System.out.println("Unnamed player  " + " scored " + score + " points.");
        return score * 1000;
    }

    public static int calculcateScore(int score, Optional<String> n) {
        String name = n.isPresent() ? n.get() : "Unnamed";
        System.out.println("Player  " + name + " scored " + score + " points.");
        return score * 1000;
    }

    public static int calculcateScore() {
        System.out.println(" No Player  , no player score ");
        return 0;
    }
    /* DOES NOT work - you need to change the signature, not the return value */
//    public static void calculcateScore(){
//        System.out.println(" No Player  , no player score ");
//
//
//    }

    public static double calcFeetAndInchesToCentimeters(double feet, double inches){
        int errCode = -1;
        if(feet < 0 || inches < 0 || inches > 12){
            return errCode;
        }

        return feet;
    }

    /*
    https://stackoverflow.com/questions/997482/does-java-support-default-parameter-values
     */
}
