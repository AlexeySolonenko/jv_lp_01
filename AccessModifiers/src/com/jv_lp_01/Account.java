package com.jv_lp_01;

import java.util.ArrayList;

public class Account {
    private String accountName;
    private int balance = 0;
    private ArrayList<Integer> transaction;

    public Account(String accountName) {
        this.accountName = accountName;
        this.transaction = new ArrayList<Integer>();
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount){
        if(amount > 0){
            transaction.add(amount);
            this.balance += amount;
            System.out.println(amount + "deposited. Balance is now " + this.balance);
        } else {
            System.out.println("cannot deposit negative sums");
        }
    }

    public void withdraw(int amount){
        int withdrawal = -amount;
        if(withdrawal < 0){
            this.transaction.add(withdrawal);
            this.balance += withdrawal;
            System.out.println(amount+ " withdrawn. Balance ins now " + this.balance);

        } else {
            System.out.println("cannot withdraw negative sums");
        }
    }

    public void calcualteBalance(){
        this.balance = 0;
        for(int i : this.transaction){
            this.balance += i;
        }
        System.out.println("Calculated balance is " + this.balance);
    }
}
