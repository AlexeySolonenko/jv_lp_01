package com.jv_lp_01;

public class Main {

    public static void main(String[] args) {
        printYearsAndDays(1051200);
    }

    public static void printYearsAndDays(long mins){
        String ret = "";
        if(mins < 0){
            System.out.println("Invalid value");
        }
        long y, d = 0;
        y = mins / 60/24/365;
        d = mins % (60*24);
        System.out.println(mins+" mins = "+y+"y and "+d+" d");
    }
}
