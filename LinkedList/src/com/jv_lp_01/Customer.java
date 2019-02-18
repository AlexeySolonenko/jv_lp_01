package com.jv_lp_01;

public class Customer {

    private String naem;
    private double balance;

    public Customer(String naem, double balance) {
        this.naem = naem;
        this.balance = balance;
    }

    public String getNaem() {
        return naem;
    }

    public void setNaem(String naem) {
        this.naem = naem;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
