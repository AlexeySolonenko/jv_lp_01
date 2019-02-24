package com.example.seriesDemoPackage;

import java.util.stream.IntStream;

public class Series {

    public static void nSum(int n){
        System.out.println("Sum of all numbers is: "  + IntStream.rangeClosed(0,n).reduce(0, (x,y) -> x + y));
    }

    public static void nProd(int n){
        System.out.println("Product of all numbers is: "  +
                IntStream.rangeClosed(0,n).reduce(1, (x,y) -> {if(x ==0) return 1; else return (x * y);}));
    }

    public static void nFib(int n){
        System.out.println("Fibonacci for " + n +" is: "
                + fibonacci(n));
    }

    public static int fibonacci(int number) {
        if (number == 1 || number == 2) {
            return 1;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
    }
}
