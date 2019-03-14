package com.jv_lp_01;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount2 {
    private volatile double balance;
    private String accountNumber;
    //private final Object balanceLock = new Object();
    private final Object accountLock = new Object();
    private final ReentrantLock balanceLock = new ReentrantLock();
    private boolean status;

    public BankAccount2(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        //balanceLock.lock();
        boolean status = false;
        try {
            if (balanceLock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    System.out.println("Amount before deposit: " + balance);
                    balance += amount;
                    status = true;
                    System.out.println("Amount after deposit: " + balance);
                } finally {
                    balanceLock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }

        } catch (InterruptedException e) {
            /* do nothing */
        }
        System.out.println("Transaction status = " + status);
    }

    public void withdraw(double amount) {
        //synchronized (balanceLock) {
        //balanceLock.lock();
        boolean status = false;
        try {
            if (balanceLock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    System.out.println("Amount before withdrawal: " + balance);
                    balance -= amount;
                    status = true;
                    System.out.println("Amount after withdrawal: " + balance);
                } finally {
                    balanceLock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }

        } catch (InterruptedException e) {
            /* do nothing */
        }
        System.out.println("Transaction status = " + status);
//        try {
//            System.out.println("Amount before withdrawal: " + balance);
//            balance -= amount;
//            System.out.println("Amount after withdrawal: " + balance);
//        } finally {
//            balanceLock.unlock();
//        }

    }

    public String getAccountNumber() {
        /* actually, getters should not be synchronized! */
        //synchronized (accountLock) {
        return accountNumber;
        //}
    }

    public void printAccountNumber() {
        //synchronized (accountLock) {
        System.out.println("Account number = " + accountNumber);
        //}
    }


}
