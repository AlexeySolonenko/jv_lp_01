package com.jv_lp_01;

public class Main {

    public static void main(String[] args) {

        for (int i = 2; i < 9; i++) {
            System.out.println("10,000 at " + i + "% interest = " + String.format("%.2f", calculateInterest(10000, i)));
        }

        for (int i = 8; i >= 2; i--) {
            System.out.println("10,000 at " + i + "% interest = " + String.format("%.2f", calculateInterest(10000, i)));
        }
        System.out.println("*************");
        int count = 0;
        for(int i = 0; i <= 32000; i++){
            if(count >=11) break;
            if(isPrime(i)){
                System.out.println("Prime numbers: "+i);
                count++;
            }
        }

        sum35();
        System.out.println(isOdd(1));
        System.out.println("sumOdd: " + sumOdd(1, 100));
        System.out.println("sumOdd: " + sumOdd(-1, 100));
        System.out.println("sumOdd: " + sumOdd(100, 100));
        System.out.println("sumOdd: " + sumOdd(100, -100));
        System.out.println("sumOdd: " + sumOdd(100, 1000));
    }

    public static double calculateInterest(double amount, double interestRate) {
        return (amount * (interestRate / 100));
    }

    /**
     *
     * @param n
     * @return boolean
     */
    public static boolean isPrime(int n) {
        if (n == 1) return false;

        for (int i = 2; i <= n / 2; i++)
            if (n % i == 0) return false;


        return true;
    }

    public static void sum35(){
        int sum = 0;
        int count = 0;
        for(int i = 1; (i <=1000);i++){
            if(count >= 5)  break;
            if(i % 3 == 0 && i %5 == 0){
                count++;
                sum += i;
                System.out.println(i+" is divisible by 3 and by 5");
            }
        }
        System.out.println("Sum of the numbers is "+sum);
    }

    public static boolean isOdd(int n){
        if(n <= 0) return false;
        if(n%2 != 0)return true;
        else return false;
    }
    public static int sumOdd(int start, int end){
        if(end <=0 || start <= 0 || end < start){
            return -1;
        }
        int sum = 0;
        for(int i = start; i <= end; i++){
            if(isOdd(i)) sum += i;
        }

        return sum;
    }


}
