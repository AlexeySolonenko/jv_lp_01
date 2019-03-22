package com.jv_lp_01;

public class BankAccount{

    private String firstName;
    private String lastName;
    private double balance;

    public static final int CHECKING = 1;
    public static final int SAVING = 2;

    private int accountType;

    public BankAccount(String firstName, String lastName, double balance, int typeOfAccount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.accountType = typeOfAccount;
    }

    /**
     * * THe branch argument is true if the customer is performing the transactions
     * * at a branch, with a teller
     * * Itr's false if the customer is performing the transaction at an ATM
     *
     * @param amount
     * @param branch
     * @return
     */
    public double deposit(double amount, boolean branch) {
        balance += amount;
        return balance;

    }

    /**
     * THe branch argument is true if the customer is performing the transactions
     * at a branch, with a teller
     * Itr's false if the customer is performing the transaction at an ATM
     *
     * @param amount
     * @param branch
     * @return
     */
    public double withdraw(double amount, boolean branch) throws IllegalStateException{
        if((amount > 500.00) && !branch) {
            throw new IllegalStateException();
        }
        balance -= amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isChecking(){
        return accountType == CHECKING;
    }

    /* More metohds that use firstName, lastName, and perform other functions */

}
