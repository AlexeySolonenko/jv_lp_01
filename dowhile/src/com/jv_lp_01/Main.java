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
        System.out.println(hasSameLastDigit(41, 22, 71));
        System.out.println(hasSameLastDigit(23, 32, 42));
        System.out.println(hasSameLastDigit(9, 99, 999));
        System.out.println("Greatest common divisor");
        System.out.println(getGreatestCommonDivisor(25,15));
        System.out.println(getGreatestCommonDivisor(12,30));
        System.out.println(getGreatestCommonDivisor(9,18));
        System.out.println(getGreatestCommonDivisor(81,153));
        printFactors(6);
        printFactors(32);
        printFactors(10);
        printFactors(-1);
        System.out.println(isPerfectNumber(6));
        System.out.println(isPerfectNumber(28));
        System.out.println(isPerfectNumber(5));
        System.out.println(isPerfectNumber(-1));


        System.out.println(reverse(-121));
        System.out.println(reverse(1212));
        System.out.println(reverse(1234));
        System.out.println(reverse(100));
        numberToWords(123);
        numberToWords(1010);
        numberToWords(1000);
        numberToWords(-12);
    }

    /**
     * @param n
     * @return
     */
    public static boolean isEvenNumber(int n) {
        if (n % 2 == 0) return true;
        else return false;
    }

    public static int sumDigits(int n) {
        if (n < 10) return -1;
        int sum = 0;
        int digit;
        int remainder = n;
        for (int i = 10000; i >= 1; i /= 10) {
            digit = remainder / i;
//            System.out.println("**");
//            System.out.println(digit);
//            System.out.println(i);
//            System.out.println(remainder);
            if (digit != 0) {
                remainder -= i * digit;
                sum += digit;

            }
        }

        System.out.println("Sum of digits is: " + sum);
        return sum;
    }

    public static int sumDigits2(int n) {
        if (n < 10) return -1;
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            n /= 10;
        }
        System.out.println("Sum of digits is: " + sum);
        return sum;
    }

    public static boolean isPalindrome(int n) {
        if (n < 0) n *= -1;
        int reverse = 0;
        int initial = n;
        while (n > 0) {
            int lastDigit = n % 10;
            reverse *= 10;
            reverse += lastDigit;
            n /= 10;
        }
        if (reverse == initial) return true;
        else return false;
    }

    public static int sumFirstAndLastDigit(int n) {
        if (n < 0) return -1;
        int lastDigit = n % 10;
        int firstDigit = 0;
        while (n > 0) {
            firstDigit = n % 10;
            n /= 10;
        }

        return lastDigit + firstDigit;
    }

    public static int getEvenDigitSum(int n) {
        if (n < 0) return -1;
        int sum = 0;
        int count = 1;
        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            if (digit % 2 == 0) sum += digit;
            count++;
        }

        return sum;
    }

    public static boolean hasSharedDigit(int x, int y) {
        if (x > 99 || x < 10 || y > 99 || y < 10) return false;
        boolean hasShared = false;
        int initY = y;
        while (x > 0) {
            int xDigit = x % 10;
            y = initY;
            while (y > 0) {
                int yDigit = y % 10;
                y /= 10;
                if (xDigit == yDigit) {
                    hasShared = true;
                    break;
                }
            }
            x /= 10;
        }
        return hasShared;
    }

    public static boolean hasSameLastDigit(int a, int b, int c) {
        if (a < 10 || b < 10 || c < 10 || a > 1000 || b > 1000 || c > 1000) {
            return false;
        }

        boolean hasSameDigit = false;
        int aLast = a % 10;
        int bLast = b % 10;
        int cLast = c % 10;
        if (aLast == bLast || aLast == cLast || bLast == cLast) {
            hasSameDigit = true;
        }
        return hasSameDigit;
    }

    public static int getGreatestCommonDivisor(int first, int second){
        int div = 0;
        if(first < 10 || second < 10){
            return -1;
        }
        int i = 1;
        while(true){
            if(first % i == 0 && second % i == 0){
                div = i;
            }
            if(i > first && i > second){
                break;
            }
            i++;
        }
        return div;
    }

    public static void printFactors(int n){
        if (n < 1) {
            System.out.println("Invalid Value");
            return;
        }
        String factors = "";
        for( int i = 1; i <=n;i++){
            if(n%i == 0){
                factors += i +" ";
            }
        }
        System.out.println(factors);
    }

    public static boolean isPerfectNumber(int n){
        if(n < 1)return false;
        int sum = 0;
        for(int i = 1;i < n;i++){
            if(n%i == 0){
                sum += i;
            }
        }
        if(sum == n)return true;
        else return false;
    }

    public static void numberToWords(int n){
        if(n < 0){
            System.out.println("Invalid Value");
            return;
        }
        String words = "";
        int numDigits = getDigitCount(n);
        int reverse = reverse(n);
        int num = n;
        int reversDigits = getDigitCount(reverse);
        int remainingZeros = numDigits - reversDigits;
        boolean notFirstLoop = false;
        while(reverse > 0){
            if(notFirstLoop)  words += " ";
            notFirstLoop = true;
            int digit = reverse % 10;
            reverse /= 10;
            String word = "";
            switch (digit){
                case 0:
                    word ="Zero";
                    break;
                case 1:
                    word ="One";
                    break;
                case 2:
                    word ="Two";
                    break;
                case 3:
                    word ="Three";
                    break;
                case 4:
                    word ="Four";
                    break;
                case 5:
                    word ="Five";
                    break;
                case 6:
                    word ="Six";
                    break;
                case 7:
                    word ="Seven";
                    break;
                case 8:
                    word ="Eight";
                    break;
                case 9:
                    word ="Nine";
                    break;
                default:
                    break;
            }
            words += word;
        }
        for(int i = 0; i < remainingZeros; i ++){
            if(notFirstLoop)  words += " ";
            notFirstLoop = true;
            words += "Zero";
        }
        System.out.println(words);

    }

    public static int reverse(int n){
        int reverse = 0;

        int num = n;
        while(num != 0){
            int digit = num % 10;
            num /= 10;
            reverse += digit;
            reverse *=10;
        }
        return reverse/10;
    }

    public static int getDigitCount(int n){
        int count = 0;
        if(n < 0){
            return -1;
        }
        if(n == 0){
            return 1;
        }
        int num = n;
        while(num > 0){
            int digit = num % 10;
            num /= 10;
            count++;
        }
        return count;
    }

}
