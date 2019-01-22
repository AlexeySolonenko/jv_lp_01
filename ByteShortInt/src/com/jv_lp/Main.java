package com.jv_lp;

public class Main {

    public static void main(String[] args) {
        /* int width is 32 */
        int myValue = 10000;
        int myMinValue = -2_147_483_648;
        int myMaxValue = 2_147_483_647;
        int myTotal = (myMinValue/2);
        System.out.println("myTotal = " + myTotal);
        /* byte has a width of 8 */
        byte myByte = 10;
        byte myMaxByte = -128;
        byte myMinByte = 127;
        byte myNewByteValue = (byte)(myMinByte/2);
        System.out.println("myByte = " + myNewByteValue);

        /* short has a widt of 16 */
        short myMinShort = -32768;
        short myMaxShort = +32767;

        /* width 64 2**63 */
        long myLongValue = 100L;
        long anotherLongVal= 9_223_372_036_854_775_807L;

        byte step = 100;
        short load = 12000;
        int loc = 24532;
        long token = 50_000L + 10L * (step + load + loc);
        /* reverse assignment to a lesser width type does not work */
        System.out.println("token = " + token);
    }
}
