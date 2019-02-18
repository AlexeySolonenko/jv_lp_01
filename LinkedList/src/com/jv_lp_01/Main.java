package com.jv_lp_01;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer("Ivan",54.96);
        Customer customer2;
        customer2 = customer;
        customer2.setBalance(12.18);
        System.out.println("Balance for customer " + customer.getNaem() + " is " + customer.getBalance());
        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        for(int i =0; i < intList.size();i++){
            System.out.println(i + ": " + intList.get(i));
        }

        intList.add(1,2);
        for(int i =0; i < intList.size();i++){
            System.out.println(i + ": " + intList.get(i));
        }




    }
}
