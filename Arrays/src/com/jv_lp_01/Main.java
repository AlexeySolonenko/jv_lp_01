package com.jv_lp_01;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] myVariable = {50};
        System.out.println(myVariable[0]);
        myVariable = new int[10];
        myVariable[5] = 50;

        System.out.println(myVariable[0]);
        System.out.println(myVariable[5]);
        for(int i = 0; i < myVariable.length; i++){
            myVariable[i] = i*10;
        }
        for(int i = 0; i < myVariable.length; i++){
            System.out.println("Element " + i + ", value is " + myVariable[i]);
        }

        /* real array usage */
        int[] myIntegers = getIntegers(5);
        for(int i = 0; i < myIntegers.length; i++){
            System.out.println("Element " + i + ", value is " + myIntegers[i]);
        }
        System.out.println("The average is " + getAverage(myIntegers));
        //int[] test

    }

    public static int[] getIntegers(int number){
        System.out.println("Enter " + number + " integer values.\n");
        int[] values = new int[number];
        for(int i = 0; i < values.length; i++){
            values[i]  = scanner.nextInt();
        }


        return values;
    }
    public static void printIntArray (int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println("Element " + i + ", value is " + array[i]);
        }

    }

    public static double getAverage(int[] array){
        int sum = 0;
        for(int i=0; i < array.length; i++){
            sum += array[i];
        }

        return (double) sum / (double)array.length;
    }

    public static int[] sortIntegers(int[] ar){
        int[] ret = new int[ar.length];
        for(int j = 0; j < ret.length; j++) {
            int prevMaxIndex = 0;
            if(j > 0) prevMaxIndex = j-1;
            int max = ret[prevMaxIndex];
            for (int i = 0; i < ar.length; i++) {
                int localMax = ar[i];

                if(ar[i] > localMax && ar[i] < ret[prevMaxIndex]){
                    max = ar[i];
                }
            }
            ret[j] = max;
        }
        return ret;

    }

}
