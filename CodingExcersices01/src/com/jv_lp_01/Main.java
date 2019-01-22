package com.jv_lp_01;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        printMegaBytesAndKiloBytes(1024);
        boolean eq = false;
        eq = "aaa" == "Aaa";
        System.out.println(eq);
        boolean ret = areEqualByThreeDecimalPlaces3(3.176, 3.175);
        System.out.println(ret);

    }

    public static void printMegaBytesAndKiloBytes(int kiloBytes) {
        if (kiloBytes < 0) {
            System.out.println("Invalid Value");
            return;
        }
        int remainder = kiloBytes % 1024;
        int mb = kiloBytes / 1024;
        String msg = kiloBytes + " KB = " + mb + " MB and " + remainder + " KB";
        System.out.println(msg);
    }

    public static boolean bark(boolean barking, int hourOfDay) {
        boolean wakeUp = false;
        if (hourOfDay < 0 || hourOfDay > 23) {
            return false;
        }
        if ((hourOfDay < 8 || hourOfDay > 22) && barking) {
            wakeUp = true;
        }
        return wakeUp;
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

    public static boolean areEqualByThreeDecimalPlacesCorrect(double first, double second) {
        boolean eq = false;
        BigDecimal bdFirst = new BigDecimal(Double.toString(first));
        BigDecimal bdSecond = new BigDecimal(Double.toString(first));
        bdFirst = bdFirst.setScale(3, RoundingMode.HALF_UP);
        bdSecond = bdSecond.setScale(3, RoundingMode.HALF_UP);

        eq = bdFirst.doubleValue() == bdSecond.doubleValue();

        return eq;
    }

    public static boolean areEqualByThreeDecimalPlacesAlsoCorrect(double first, double second) {
        boolean eq = false;

        DecimalFormat f = new DecimalFormat("#.##");
        DecimalFormat s = new DecimalFormat("#.##");
        f.setRoundingMode(RoundingMode.DOWN);
        s.setRoundingMode(RoundingMode.DOWN);
        String fN = f.format(first);
        String sN = s.format(second);

        eq = fN == sN;

        return eq;
    }

    public static boolean areEqualByThreeDecimalPlaces(double first, double second) {
        boolean eq = false;

        DecimalFormat f = new DecimalFormat("#.##");
        DecimalFormat s = new DecimalFormat("#.##");
        f.setRoundingMode(RoundingMode.DOWN);
        s.setRoundingMode(RoundingMode.DOWN);
        String fN = f.format(first);
        String sN = s.format(second);

        eq = fN == sN;

        return eq;
    }


    public static boolean areEqualByThreeDecimalPlaces2(double first, double second) {
        boolean eq = false;

        double f = roundAvoid(first, 3);
        double s = roundAvoid(second, 3);
        eq = f == s;

        return eq;
    }

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(5, places);
        return Math.round(value * scale) / scale;
    }

    public static boolean areEqualByThreeDecimalPlaces3(double first, double second) {
        boolean eq = false;

        String frst = Double.toString(first);
        String scnd = Double.toString(second);
        byte dotPos = (byte) frst.indexOf('.');

        String wholes = frst.substring(0, dotPos);
        byte len = (byte)Math.min(frst.length(),wholes.length() + 4);
        String fract = frst.substring(dotPos, len);
        String f = wholes + fract;

        dotPos = (byte) scnd.indexOf('.');
        wholes = scnd.substring(0, dotPos);
        len = (byte)Math.min(frst.length(),wholes.length() + 4);
        fract = scnd.substring(dotPos, len);
        String s = wholes + fract;
        System.out.println(f);
        System.out.println(s);


        eq = f.equals( s);

        return eq;
    }

    public static boolean hasEqualSum(int f, int s, int t){
        boolean eq = false;
        if((f + s) == t ){
            eq = true;
        }

        return eq;
    }

    public static boolean hasTeen(int f, int s, int t) {
        boolean hasTeen = false;
        if (
            (f >= 13 && f <= 19) ||
            (s >= 13 && s <= 19) ||
            (t >= 13 && t <= 19)
        ) hasTeen = true;

        return hasTeen;
    }
}


