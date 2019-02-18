package com.jv_lp_01;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Customer {
    private ArrayList<Double> txs = new ArrayList<Double>();
    private String name;
    private int id;
    private Scanner scanner = new Scanner(System.in);


    public Customer(Double tx, String name, int id) {
        ArrayList<Double> txs = new ArrayList<Double>();
        txs.add(tx);
        this.txs = txs;
        this.name = name;
        this.id = id;
    }

    public Customer(ArrayList<Double> txs, String name, int id) {
        this.txs = txs;
        this.name = name;
        this.id = id;
    }

    public void addTransactions(){
        System.out.println("0 - Exit");
        System.out.println("1 - Add");
        int opt = scanner.nextInt();
        if (opt == 0) {
            return;
        } else {
            addTransactions(scanner.nextDouble());
            addTransactions();
        }
    }


    /**
     * @param txs
     * @return
     */
    public boolean addTransactions(ArrayList<Double> txs) {

        for (int i = 0; i < txs.size(); i++) {
            if (!validateTx(txs.get(i))) {
                System.out.println("Amount of one of the transactions in a batch exceeds set limits. Aborting the operation");
                return false;
            }
        }
        /* if all tx comply */
        this.txs.addAll(txs);

        return true;
    }

    /**
     *
     * @param tx
     * @return
     */
    public boolean addTransactions(Double tx) {
        if (!validateTx(tx)) {
            System.out.println("Amount of one of the transactions in a batch exceeds set limits. Aborting the operation");
            return false;
        }

        this.txs.add(tx);

        return true;
    }

    private boolean validateTx(Double tx) {
        if (tx > 100.00 || tx < -100.00) {
            return false;
        }
        return true;
    }


    public String listTransactions() {
        return txs.stream().map(n -> { return n.toString();}).collect(Collectors.joining(" | "));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
