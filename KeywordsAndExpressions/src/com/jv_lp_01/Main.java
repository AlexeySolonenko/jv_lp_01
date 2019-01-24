package com.jv_lp_01;

public class Main {

    public static void main(String[] args) {
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
    }
}
