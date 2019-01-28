package com.jv_lp_01;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        int switchValue = 2;
        switch (switchValue) {
            case 1:
                System.out.println("Value was 1");
                break;
            case 2:
            case 3:
                System.out.println("Value 2 or 3");
                System.out.println("Actuall it was " + switchValue);
            default:
                System.out.println("Default value");
                break;
        }
        String month = "JAnuary";
        switch (month) {
            case "January":
                System.out.println("Capitalized January");
            case "february":
            case "january":
            case "december":
                System.out.println("Winter");
                break;
            default:
                System.out.println("Value not found");
                break;
        }

    }

    public static void printNumberInWord(int n) {
        switch (n) {
            case 0:
                System.out.println("ZERO");
                break;
            case 1:
                System.out.println("ONE");
                break;
            case 2:
                System.out.println("TWO");
                break;
            case 3:
                System.out.println("THREE");
                break;
            case 4:
                System.out.println("FOUR");
                break;
            case 5:
                System.out.println("FIVE");
                break;
            case 6:
                System.out.println("SIX");
                break;
            case 7:
                System.out.println("SEVEN");
                break;
            case 8:
                System.out.println("EIGHT");
                break;
            case 9:
                System.out.println("NINE");
                break;
            default:
                System.out.println("OTHER");
                break;
        }
    }

    public static boolean isLeapYear(int year) {
        boolean isLeap = false;
        if (year <= 1 || year >= 9999) {
            return false;
        }
        boolean fourAndNot100 = ((year % 4) == 0) && ((year % 100) != 0);
        boolean fourHndr = ((year % 400) == 0);
        if (fourAndNot100 || fourHndr) {
            isLeap = true;
        }

        return isLeap;
    }

    public static int getDaysInMonth(int month, int year) {
        if(month < 1 || month > 12){
            return -1;
        }
        if(year < 1 || year > 9999){
            return -1;
        }
        int daysInMonth = 30;
        int[] monthsOf31 = {1, 3, 5, 7, 8, 10, 12};
        // IntStream does not work
        if (month == 2 && isLeapYear(year)) {
            return 29;
        } else if (month == 2) {
            return 28;
        }

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            default:
                return 30;
        }


    }

}
