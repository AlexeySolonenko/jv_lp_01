package com.jv_lp_01;

public class Cheese extends Addition {


    public Cheese() {
        this(1);
    }

    public Cheese(int timesAmount) {
        this(0.85,timesAmount);
    }


    public Cheese(double price, int timesAmount) {
        super(Addition.CHEESE, price, timesAmount);
    }
}
