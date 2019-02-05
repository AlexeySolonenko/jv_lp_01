package com.jv_lp_01;

public class Drinks extends Addition {

    public Drinks() {
        this(1);
    }

    public Drinks(int timesAmount) {
        this(0.30,timesAmount);
    }

    public Drinks(double price, int timesAmount) {
        super(Addition.LETTUCE, price, timesAmount);
    }
}
