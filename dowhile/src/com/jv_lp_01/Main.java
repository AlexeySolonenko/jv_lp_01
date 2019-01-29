package com.jv_lp_01;

public class Main {

    public static void main(String[] args) {
        int count = 1;
        while (count != 6) {
            System.out.println("Count value is " + count);
            count++;
        }
        int count2 = 0;
        /* that works! */
        for (int j = 0; count2 <= 4; j++) {
            count2 = j;
        }

        count = 1;
        do {
            System.out.println("Count value was " + count);
            count++;
        } while (count != 6);
        int number = 4;
        int finishNumber = 20;

        while (number <= finishNumber) {
            number++;
            if (!isEvenNumber(number)) continue;
            System.out.println("Even number " + number);
        }

        sumDigits(125);
        sumDigits2(125);
        sumDigits(50);
        sumDigits2(50);
        sumDigits(250);
        sumDigits2(250);
        sumDigits(6000);
        sumDigits2(6000);
        sumDigits(7654);
        sumDigits2(7654);

        System.out.println(isPalindrome(101));
        System.out.println(isPalindrome(1));
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(123));
        System.out.println(isPalindrome(11212));
        System.out.println(isPalindrome(707));
        System.out.println(sumFirstAndLastDigit(252));
        System.out.println(sumFirstAndLastDigit(257));
        System.out.println(sumFirstAndLastDigit(0));
        System.out.println(sumFirstAndLastDigit(5));
        System.out.println(sumFirstAndLastDigit(-10));
        System.out.println(getEvenDigitSum(123456789));
        System.out.println(getEvenDigitSum(252));
        System.out.println(getEvenDigitSum(-22));
        System.out.println(hasSharedDigit(12, 23));
        System.out.println(hasSharedDigit(9, 99));
        System.out.println(hasSharedDigit(15, 55));
        System.out.println(hasSharedDigit(33, 5));
    }

    /**
     * @param n
     * @return
     */
    public static boolean isEvenNumber(int n) {
        if (n % 2 == 0) return true;
        else return false;
    }

    public static int sumDigits(int n){
        if(n <10) return -1;
        int sum = 0;
        int digit;
        int remainder = n;
        for(int i = 10000; i >= 1; i /= 10){
            digit = remainder / i;
//            System.out.println("**");
//            System.out.println(digit);
//            System.out.println(i);
//            System.out.println(remainder);
            if(digit != 0) {
                remainder -= i * digit;
                sum += digit;

            }
        }

        System.out.println("Sum of digits is: "+ sum);
        return sum;
    }

    public static int sumDigits2(int n){
        if(n < 10) return -1;
        int sum = 0;
        while (n > 0){
            int digit = n %10;
            sum += digit;
            n /= 10;
        }
        System.out.println("Sum of digits is: "+ sum);
        return sum;
    }

    public static boolean isPalindrome(int n){
        if(n < 0) n *= -1;
        int reverse = 0;
        int initial = n;
        while (n > 0){
            int lastDigit = n %10;
            reverse *= 10;
            reverse += lastDigit;
            n /= 10;
        }
        if(reverse == initial)return true;
        else return false;
    }

    public static int sumFirstAndLastDigit(int n){
        if(n < 0) return -1;
        int lastDigit = n %10;
        int firstDigit = 0;
        while(n > 0){
            firstDigit = n%10;
            n/=10;
        }

        return lastDigit + firstDigit;
    }

    public static int getEvenDigitSum(int n){
        if(n < 0) return -1;
        int sum = 0;
        int count = 1;
        while (n > 0){
            int digit = n % 10;
            n /= 10;
            if(digit %2 == 0) sum += digit;
            count++;
        }

        return sum;
    }

    public static boolean hasSharedDigit(int x, int y){
        if(x > 99 || x < 10 || y > 99 || y < 10) return false;
        boolean hasShared = false;
        int initY = y;
        while (x > 0) {
            int xDigit = x % 10;
            y = initY;
            while(y > 0){
                int yDigit = y %10;
                y /= 10;
                if(xDigit == yDigit) {
                    hasShared = true;
                    break;
                }
            }
            x /=10;
        }
        return hasShared;
    }
}
