package com.jv_lp_01;


public class Main {

    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;
        int result = 1;

        int highScore = calculateScore(true, 800, 5, 100);
        System.out.println("Your final score was " + highScore);
        highScore = calculateScore(true, 1000, 8, 200);
        System.out.println("Your final score was " + highScore);
        score = 20000;
        levelCompleted = 8;
        bonus = 200;
        highScore = calculateScore(gameOver, score, levelCompleted, bonus);
        System.out.println("Your final score was " + highScore);

        String message = "";

        message = displayHighScorePosition("John",1500);
        message += displayHighScorePosition("Tom",900);
        message += displayHighScorePosition("Bob",400);
        message += displayHighScorePosition("Jack",50);
        System.out.println(message);
    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {
//        boolean gameOver = true;
//        int score  = 800;
//        int levelCompleted = 5;
//        int bonus = 100;

        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 1000;
            return finalScore;
        } else {
            return -1;
        }

    }

    public static String displayHighScorePosition(String name, int score){
        byte position = calculateHighScorePosition(score);
        return "Position of player named \"" + name + "\" is " + position+".\n";
    }

    public static byte calculateHighScorePosition(int score){
        byte ret = 4;
        if(score >= 1000){
            ret = 1;
        } else if(score >= 500){
            //return 2;
            ret = 2;
        } else if(score >= 100){
            ret = 3;
            //return 3;
        }
            // else {
            //return 4;
        return ret;
        //}
    }
}
