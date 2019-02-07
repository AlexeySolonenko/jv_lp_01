package com.jv_lp_01;

public class Lettuce extends Extra {

    public Lettuce() {
        this(1);
    }

    public Lettuce(int timesAmount) {
        this(0.35,timesAmount);
    }

    public Lettuce(double price, int timesAmount) {
        super(Extra.LETTUCE, price, timesAmount);
    }
}
