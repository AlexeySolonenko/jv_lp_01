package com.jv_lp_01;

public class Main {

    public static void main(String[] args) {
        String numberAsString = "2018.125";
        System.out.println("numberAsString = " + numberAsString);
        double number = Double.parseDouble(numberAsString);
        System.out.println("number = " + number);
        numberAsString += 1;
        number += 1;
        System.out.println("numberAsString = " + numberAsString);
        System.out.println("number = " + number);
        System.out.println(canPack(1,0,4));
        System.out.println(canPack(1,0,5));
        System.out.println(canPack(0,5,4));
        System.out.println(canPack(2,2,12));
        System.out.println(canPack(-3,2,12));

        System.out.println("largest prime");
        System.out.println(isPrimeNumber(9));
        System.out.println(getLargestPrime(21));
        System.out.println(getLargestPrime(217));
        System.out.println(getLargestPrime(0));
        System.out.println(getLargestPrime(45));
        System.out.println(getLargestPrime(-1));
        printSquareStar(5);
        printSquareStar(8);
    }

    public static boolean canPack(int bCnt, int sCnt, int goal){
        if(bCnt < 0 || sCnt < 0 || goal < 0){
            return false;
        }
        int big = 5;
        int sm = 1;

        if ( goal % big == 0 && (goal/big >= bCnt)) {
            return true;
        } else if( goal <= sCnt) {
            return true;
        }
        /* big count can result in more than goal, or less, let's find the remainder */
        int rem = -1;
        int maxBigs = goal / 5;
        if(maxBigs > bCnt) rem = goal - ( bCnt * big);
        else rem = goal % 5;
        if(sCnt >= rem) return true;
        else return false;
    }

    public static int getLargestPrime(int n){
        if(n <= 1) return -1;
        int largestPrime = -1;
        for(int factor = 2; factor <= n;factor++){
            if(n % factor == 0){
                if(factor == 3){
                    largestPrime = factor;
                } else {
                    boolean prime = true;
                    for(int i = 2; i < factor;i++){
                        if(factor %i == 0) prime = false;
                    }
                    if(prime) largestPrime = factor;
                }

            }
        }
        return largestPrime;
    }

    public static boolean isPrimeNumber(int n){
        if(n <= 1) return false;
        if (n > 1 && n <=3) return true;
        boolean prime = true;
        for(int i = 2; i < n;i++){
            if(n %i == 0) prime = false;
        }

        return prime;
    }

    public static void printSquareStar(int n){
        if(n < 5) {
            System.out.println("Invalid Value");
            return;
        }
        int row = 1;
        int col = 1;
        String line = "";
        for(;row <=n;row++){
            line = "";
            for(col = 1;col <= n;col++){
                if(row == 1 || row == n  || row == col || col== n || col ==1|| ((n-row+1) == col) ) line += "*";
                else line += " ";
            }
            System.out.println(line);
        }

    }
}
