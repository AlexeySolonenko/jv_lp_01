package com.jv_lp_01;

public class Main {

    public static void main(String[] args) {

        /* primitives are copied by value */
        int myIntValue = 10;
        int anothreIntValue = myIntValue;
        System.out.println("myIntValue = " + myIntValue);
        System.out.println("anotherIntValue = " + anothreIntValue);

        anothreIntValue++;
        System.out.println("myIntValue = " + myIntValue);
        System.out.println("anotherIntValue = " + anothreIntValue);

        /* objects by reference */
        int[] myIntArray = new int[5];
        int[] myOtherIntArray = myIntArray;
        System.out.println("myIntArray[0] = " + myIntArray[0]);
        System.out.println("myOtherIntArray[0] = " + myOtherIntArray[0]);
        myIntArray[0] = 5;
        System.out.println("myIntArray[0] = " + myIntArray[0]);
        System.out.println("myOtherIntArray[0] = " + myOtherIntArray[0]);
        modifyArray(myIntArray);
        System.out.println("After modify myIntArray[0] = " + myIntArray[0]);
        System.out.println("After modify myOtherIntArray[0] = " + myOtherIntArray[0]);
        /* dereference */
        modifyArrayWithDereference(myIntArray);
        System.out.println("After modify after deref and link remains myIntArray[0] = " + myIntArray[0]);
        System.out.println("After modify after deref  and link remains myOtherIntArray[0] = " + myOtherIntArray[0]);

        myOtherIntArray = new int[]{1,2,3,4,5};
        System.out.println("After modify after explicit deref  myIntArray[0] = " + myIntArray[0]);
        System.out.println("After modify after explicit deref  myOtherIntArray[0] = " + myOtherIntArray[0]);




    }
    private static void modifyArray(int[] array){
        array[0] = 3;

    }

    private static void modifyArrayWithDereference(int[] array){
        array[0] = 2;
        array = new int[]{1,2,3,4,5};

    }
}
