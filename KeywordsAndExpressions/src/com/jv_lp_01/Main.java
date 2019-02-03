package com.jv_lp_01;

public class Main {

    public static void main(String[] args) {
<<<<<<< HEAD
        System.out.println(calcFeetAndInchesToCentimeters(50));
        System.out.println(calcFeetAndInchesToCentimeters(5,7));
    }


    public static int calcFeetAndInchesToCentimeters(int feet, int inches){
        int error = -1;
        int cents = error;
        if(feet <= 0 || inches >= 12 || inches <= 0){
            return error;
        }

        inches = inches + feet * 12;
        cents = (int)Math.round(inches * 2.54);

        return cents;
    }

    public static int calcFeetAndInchesToCentimeters(int inches){
        int error = -1;
        int cents = error;
        if(inches <= 0){
            return error;
        }
        int feet = inches / 12;
        inches = inches % 12;
        cents = calcFeetAndInchesToCentimeters(feet, inches);

        return cents;
=======
	// write your code here
    // a mile is equal to 1.609344 kilomters
        // except reserved words - expression
        double kilometres = (100 * 1.609344);
        int highScore = 5;
        if(highScore == 50){
            System.out.printf("This is an expression");
        }



>>>>>>> 7f579f49777e583765512ebb41f9bd86234386bd
    }
}
