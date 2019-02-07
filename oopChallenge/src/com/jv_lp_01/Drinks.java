package com.jv_lp_01;

public class Drinks extends Extra {

    public Drinks() {
        this(1);
    }

    public Drinks(int timesAmount) {
        this(0.70,timesAmount);
    }

    public Drinks(double price, int timesAmount) {
        super(Extra.DRINKS, price, timesAmount);
    }
}
