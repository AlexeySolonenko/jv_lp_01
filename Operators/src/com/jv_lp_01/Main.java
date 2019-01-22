package com.jv_lp_01;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int result = 1 + 2;
        result += 2;
        System.out.println("1 + 2 = " + result);
        int previousResult = result;
        result = result - 1;
        System.out.println(previousResult + " - 1 = " + result);
        previousResult = result;
        result = result * 10;
        System.out.println(previousResult + " * 10 = " + result);
        previousResult = result;
        result = result / 2;
        System.out.println(previousResult + " / 2 = " + result);
        previousResult = result;
        result = result % 3;
        System.out.println(previousResult + " % 3 = " + result);
        result++;
        System.out.println("Result++ : " + result);
        result--;
        System.out.println("Result-- : " + result);
        result += 2;
        System.out.println("Result+=2 : " + result);
        result *= 10;
        System.out.println("Result-= : " + result);
        result /= 10;
        result -= 10;
        System.out.println("Result-= : " + result);
        result /= 10;
        System.out.println("Result/= : " + result);

        boolean isAlien = false;
        if (isAlien == false)
            System.out.println("It is not an alient!");

        isAlien = true;
        if (isAlien != true) {
            System.out.println("It is Alien!");
        }

        int topScore = 80;
        if ((topScore < 90) && isAlien) System.out.println("You got the low score");

        /* Second lecture on operators */

        boolean boiling = true;
        boolean water = false;
        if(boiling || water) System.out.println("Water or boiling is true");
        boolean res = boiling || water;
        System.out.println(res);
        boiling= false;
        res = boiling || water;

        System.out.println(res);

        int newValue = 50;
        boolean isCar = false;
        if(isCar=true) System.out.println("Equals to true");


        int someValue = (newValue > 60) ? 45 : 10;
        System.out.println("someValue: " + someValue);
        someValue = (newValue > 45) ? 45 : 10;
        System.out.println("someValue: " + someValue);

        double volume = 20d;
        double height = 80d;
        double total = (volume + height) * 25;
        double rem = total % 40;
        if(rem <= 20) System.out.println("Total was over the limit");
        System.out.println("Remainder: " + rem);



    }
}
