package com.jv_lp_01;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Customer {
    private ArrayList<Double> txs = new ArrayList<Double>();
    private String name;
    private int id;

    public Customer(ArrayList<Double> txs, String name, int id) {
        this.txs = txs;
        this.name = name;
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
        if (tx > 100.00 || tx < 100.00) {
            return false;
        }
        return true;
    }

    public void listTransactions() {
        txs.forEach((t) -> System.out.println(t));
    }

    public void updateName() {

    }

    public int getId() {
        return id;
    }
}
