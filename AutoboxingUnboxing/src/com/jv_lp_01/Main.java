package com.jv_lp_01;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String[] strArray = new String[10];
        int[] intArray = new int[10];

        ArrayList<String> strArrayList = new ArrayList<String>();
        strArrayList.add("Tim");

        //ArrayList<int>intArrayList = new ArrayList<int>();
        /*one wayto do - to make a class to handle a single int - not an option */

        /* better use autoboxing - automatic provider of wrappers */
        Integer integer = new Integer(50);
        Double doubleValue = new Double(12.25);
        ArrayList<Integer>intArrayList2 = new ArrayList<Integer>();
        for(int i = 0; i <=10;i ++) {
            intArrayList2.add(Integer.valueOf(i));
        }

        for(int i = 0; i<=10;i++){
            System.out.println(i + " ---> " + intArrayList2.get(i).intValue());
        }

        Integer myIntVal = 56; // Integer.valueOf(56);
        int myInt = myIntVal; // myIntVal.intValue();

        ArrayList<Double> myDVals = new ArrayList<Double>();
        for(double dbl = 0.0; dbl < 10.0; dbl +=0.5){
            myDVals.add(dbl);
        }
        for(int i = 0; i < myDVals.size(); i++){
            //double val = myDVals.get(i).doubleValue();
            double val = myDVals.get(i);
            System.out.println(i + " ---> " + val);
        }



    }
}
