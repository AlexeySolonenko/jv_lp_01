package com.company;

public class Main {

    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 4000;
        int levelCompleted = 5;
        int bonus = 100;
        if (score < 5000 && score > 1000) {
            System.out.printf("Your score was 5000");
        } else if (score < 1000) {
        } else {
            System.out.printf("Got here");
        }
        if(gameOver == true){
            int finalScore = score;
            System.out.printf("Your final score was " + finalScore);
        }
        // outer scope is available automatically, inner scope is not available by default
        //int savedFinalScore = finalScore;


    }
}
