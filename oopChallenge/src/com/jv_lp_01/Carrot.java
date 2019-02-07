package com.jv_lp_01;

public class Carrot extends Extra {

    public Carrot() {
        this(1);
    }

    public Carrot(int timesAmount) {
        this(0.15,timesAmount);
    }

    public Carrot(double price, int timesAmount) {
        super(Extra.CARROT, price, timesAmount);
    }
}
