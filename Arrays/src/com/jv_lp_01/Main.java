package com.jv_lp_01;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
//        int[] myVariable = {50};
//        System.out.println(myVariable[0]);
//        myVariable = new int[10];
//        myVariable[5] = 50;
//
//        System.out.println(myVariable[0]);
//        System.out.println(myVariable[5]);
//        for(int i = 0; i < myVariable.length; i++){
//            myVariable[i] = i*10;
//        }
//        for(int i = 0; i < myVariable.length; i++){
//            System.out.println("Element " + i + ", value is " + myVariable[i]);
//        }

        /* real array usage */
//        int[] myIntegers = getIntegers(5);
//        for(int i = 0; i < myIntegers.length; i++){
//            System.out.println("Element " + i + ", value is " + myIntegers[i]);
//        }
//        System.out.println("The average is " + getAverage(myIntegers));



//        int[] test = {4, 6, 2, 3, 1, 7, 5};
//        test = sortIntegers(test);
//        printIntArray(test);


        int count = 10;
        int[] input = getIntegers(count);
        System.out.println("Minimum entered number is: " + findMin(input));
        reverse(input);
        System.out.println("Reverse of your array is : " );
        printIntArray(input);
        System.out.println("Reverse of your array is : "+Arrays.toString(input) );

    }

    public static int[] getIntegers(int number) {
        System.out.println("Enter " + number + " integer values.\n");
        int[] values = new int[number];
        for (int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt();
        }


        return values;
    }

    public static void printIntArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + ", value is " + array[i]);
        }

    }

    public static double getAverage(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        return (double) sum / (double) array.length;
    }

    /**
     * @param ar int[]
     * @return int[]
     */
    public static int[] sortIntegers(int[] ar) {
        int[] sortedArray = new int[ar.length];
        int[] ret = new int[ar.length];
        for (int i = 0; i < ar.length; i++) {
            sortedArray[i] = ar[i];
        }
        sortedArray = Arrays.copyOf(ar, ar.length);

        /* I did not mange = need to seek for some math/logic excercise */
        for (int i = 0; i < ar.length; i++) {
            for (int j = 1; j < ar.length; j++) {
                if (j == 1 && i == 0) {
                    if (ar[0] > ar[1]) ret[0] = ar[0];
                } else if (i == 0) {
                    if (ar[j] > ar[j - 1]) ret[0] = ar[j];
                } else {
                    if (ar[j] > ar[j - 1] && ar[j] < ret[i - 1]) ret[i] = ar[i];
                }
            }
        }

        boolean flag = true;
        int temp;
        while (flag) {
            flag = false;
            for (int i = 0; i < sortedArray.length - 1; i++) {
                if (sortedArray[i] < sortedArray[i + 1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                }
            }
        }
        return sortedArray;
    }



    /**
     * @param ar int[]
     * @return int[]
     */
    public static int findMin(int[] ar) {
        var min = ar[0];
        for(int i = 0;i < ar.length; i ++ ){
            if(ar[i] < min) min = ar[i];
        }

        return  min;
    }

    public static void reverse(int[] ar){
        int[] ret = Arrays.copyOf(ar,ar.length);
        for(int i = 0; i < ar.length; i++){
            ar[i] = ret[ar.length-i-1];
        }
    }

}
