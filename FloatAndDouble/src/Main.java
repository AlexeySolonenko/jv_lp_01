//package com.jv_lp_01;

public class Main {
    /**
     *
     * @param args
     */
    public static void main(String[] args){
        int myIntValue = 5;
        /* float has 7 digits precision, 32 widt, 4 bytes */
        float myFloatValue = 21.6f/7;
        /* double width is 64, 8 bytes, 18 digits */
        double myDoubleValue = 5.25d / 7d;

        System.out.println("myIntValue = " + myIntValue);
        System.out.println("myFloatValue = " + myFloatValue);
        /* only double is recommended */
        System.out.println("myDoubleValue = " + myDoubleValue);

        short kilos = 15;
        double pounds = kilos / 0.45359237;
        System.out.println(pounds);

        double double2 = 1_000.340_234d;
        System.out.println(double2);
    }
}
