package com.jv_lp_01;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*
        primitive types
        byte
        short
        int
        long
        float
        double
        char
        boolean
         */
        /* String is a class */
        String myString = "This is a string";
        myString += myString + ", and this is more";
        System.out.println(myString + " \u009E 2015");
        String numberString = "250.55";
        numberString = numberString + "49.95";
        System.out.println("The result is " + numberString);

        String lastString = "10";
        int myInt = 50;
        lastString = lastString + myInt;
        System.out.println("Last string is "+lastString);
        double doubleNumber = 120.47;
        System.out.println("Last value: " + (lastString + doubleNumber));
    }
}
