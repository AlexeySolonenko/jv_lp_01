package com.jv_lp_01;

import java.util.Formatter;

public class Main {

    /* FINAL is ised to denote constants */
    private static final String INVALID_VALUE_MESSAGE = "Invalid value ";

    public static void main(String[] args) {
	// write your code here
        getDurationString(250,45);
        getDurationString(1654986);
        getDurationString(-1654986);
    }

    public static String getDurationString(long mins, long sec){
        String ret = INVALID_VALUE_MESSAGE;

        if(mins < 0 || sec > 59 || sec < 0) {
            System.out.println(ret);
            return ret;
        }
        long totalSec = mins * 60 + sec;

        long h = totalSec / 60 / 60;
        mins = totalSec % ( 60 * 60) / 60;
        sec = totalSec - h * 3600 - mins * 60;
        String hrs = String.format("%2s",Long.toString(h)).replace(' ','0');
        String m = String.format("%2s",Long.toString(mins)).replace(' ','0');
        String s = String.format("%2s",Long.toString(sec)).replace(' ','0');
        ret = hrs + "h " + m + "m " + s + "s";
        System.out.println(ret);


        return ret;
    }

    public static String getDurationString(long sec){
        String ret = Main.INVALID_VALUE_MESSAGE;
        ret = INVALID_VALUE_MESSAGE;

        if(sec < 0) {
            System.out.println(ret);
            return ret;
        }
        long mins = sec / 60;
        sec = sec % 60;

        ret = getDurationString(mins, sec);

        return ret;
    }

    public static double area(double radius){
        if(radius < 0){
            return -1.0D;
        }
        return radius * radius * Math.E;
    }

    public static double area(double x, double y){
        if(x < 0 || y < 0){
            return -1.0D;
        }
        return x*y;
    }
}
