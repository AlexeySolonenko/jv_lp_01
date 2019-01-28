package com.jv_lp_01;

public class Main {

    public static void main(String[] args) {
        printYearsAndDays(525600);
        printYearsAndDays(1051200);
        printYearsAndDays(561600);
    }

    public static void printYearsAndDays(long mins){
        long y,d= 0;
        if(mins < 0){
            System.out.println("Invalid Value");
            return;
        }
        y = mins / (24*60*365);
        d = (mins % (24*60*365))/24/60;
        //d = mins - y *(60*365);
        System.out.println(mins + " min = "+y+" y and "+d+" d");
    }

    public static void printEqual(int a, int b, int c){
        if(a < 0 || b < 0 || c < 0){
            System.out.println("Invalid Value");
            return;
        }

        if(a == b && b == c && c == a){
            System.out.println("All numbers are equal");
            return;
        }
        if(a != b && b != c && c!=a){
            System.out.println("All numbers are different");
            return;
        }
        System.out.println("Neither all are equal or different");
        return;
    }

    public static boolean isCatPlaying(boolean summer, int temperature){
        boolean isPlaying = false;
        int floor = 25;
        int ceil = summer ? 45 : 35;
        if(temperature >= floor && temperature <= ceil){
            isPlaying = true;
        }
        return isPlaying;
    }
}
