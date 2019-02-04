package com.jv_lp_01;

public class BankAccount {

    private String accNumber;
    private double balance = 0.0;
    private String customerName= "";
    private String email;
    private String phoneNumber;

    public BankAccount(){
        //System.out.println("Empty constructor called");
        this("56789",2.50,"Default name","Default address","default phone");
        System.out.println("Empty constructor called");

    }

    public BankAccount(String customerName, String email, String phoneNumber) {
        this("00000",10.55,customerName,email,phoneNumber);

//        this.customerName = customerName;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
    }

    public BankAccount(String number, double balance, String customerName, String customerEmail, String customPhone){
        /* HOWEVER preferrably this.number = "1q234" - i.e. avoid setters, but there is a discussion around this */
        this.setAccNumber(number);
        this.setBalance(balance);
        this.setCustomerName(customerName);
        this.setEmail(customerEmail);
        this.setPhoneNumber(customPhone);

    }
    public BankAccount deposit(double amount){
        this.balance += amount;

        return this;
    }
    public String withdraw(double amount){
        String msg = "";
        if(amount < this.balance){
            this.balance -= amount;
            msg = "Withdrawal successfull. New balance is: " + this.balance;
        } else {
            msg = "You do not have enough funds to withdraw. You may withdraw only: " + (this.balance - 0.01);
        }
        return msg;
    }
    // region GETTERS
    public String getAccNumber() {
        return accNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // endregion GETTERS
    // region SETTERS

    public BankAccount setAccNumber(String accNumber) {
        this.accNumber = accNumber;
        return this;
    }

    public BankAccount setBalance(double balance) {
        this.balance = balance;
        return this;
    }

    public BankAccount setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public BankAccount setEmail(String email) {
        this.email = email;
        return this;
    }

    public BankAccount setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
    // endrgion SETTERS
}
