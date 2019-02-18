package com.jv_lp_01;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        /* todo to complete remove methods and to test more in depths - streams exhausted my patiens */
        Customer customer = new Customer(3.0,"Tom",4);
        customer.addTransactions(2.0);
        customer.addTransactions(2.0);
        customer.addTransactions(2.0);
        customer.addTransactions(2.0);

        Bank bank = new Bank();
        bank.addBranch("Moscow");
        bank.addBranch("SPeterburg");
        bank.addBranch("Sochi");
        bank.mainMenu();

    }
}
