package com.jv_lp_01;



public class Main {



    public static void main(String[] args) {
	    final BankAccount2 account = new BankAccount2("12345-648",1000.00);

        (new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(300.00);
                account.withdraw(50.00);
            }
        })).start();

        (new Thread(new Runnable() {
            @Override
            public void run() {
                account.withdraw(203.75);
                account.withdraw(100.00);
            }
        })).start();

    }
}
