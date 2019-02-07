package com.jv_lp_01;

public class Chips extends Extra {

    public Chips() {
        this(1);
    }

    public Chips(int timesAmount) {
        this(0.35,timesAmount);
    }

    public Chips(double price, int timesAmount) {
        super(Extra.CHIPS, price, timesAmount);
    }
}
