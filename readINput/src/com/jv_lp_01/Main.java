package com.jv_lp_01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter your year of birth: ");
//
//        boolean hasNextInt = scanner.hasNextInt();
//
//        if (hasNextInt) {
//            int yearOfBirth = scanner.nextInt();
//            scanner.nextLine();
//            System.out.println("Enter your name: ");
//            String name = scanner.nextLine();
//            int age = 2019 - yearOfBirth;
//            if (age >= 0 && age <= 100) {
//                System.out.println("Your name is " + name + ", and you are " + age + " years old");
//            } else {
//                System.out.println("Invalid year of birth");
//            }
//        } else {
//            System.out.println("Unable to parse year of birth");
//        }

        //read10Ints();
        minMax();
        scanner.close();


    }


    public static void read10Ints() {
        int sum = 0;
        Scanner scn = new Scanner(System.in);
        for (int s = 1; s <= 10; s++) {
            System.out.println("Enter number #" + s + ": ");
            //scn.nextLine();
            //sum += scn.nextInt();
            if (scn.hasNextInt()) {
                sum += scn.nextInt();
            } else {
                System.out.println("Please, try again");
                s--;
                //scn.next();
                scn.nextLine();
            }
        }
        scn.close();
        System.out.println("Your entered 10 number which sum is: " + sum);
    }

    public static void minMax(){
        Scanner s = new Scanner(System.in);
        int min = 0;
        int max = 0;
        int n = 0;
        while(true){
            System.out.println("Enter number");
            if(s.hasNextInt()){
                n = s.nextInt();
                if(n > max) max = n;
                if (n < min) min = n;
            } else {
                System.out.println("Breaking the loop. The min is: " + min + ". The max is: " + max);
                break;
            }
            /* present in the course, but works without it */
            //s.nextLine();
        }
    }


}
