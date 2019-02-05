package com.jv_lp_01;

public class Chips extends Addition {

    public Chips() {
        this(1);
    }

    public Chips(int timesAmount) {
        this(0.35,timesAmount);
    }

    public Chips(double price, int timesAmount) {
        super(Addition.LETTUCE, price, timesAmount);
    }
}
