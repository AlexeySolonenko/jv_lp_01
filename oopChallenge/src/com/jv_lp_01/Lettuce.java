package com.jv_lp_01;

public class Lettuce extends Addition {

    public Lettuce() {
        this(1);
    }

    public Lettuce(int timesAmount) {
        this(0.35,timesAmount);
    }

    public Lettuce(double price, int timesAmount) {
        super(Addition.LETTUCE, price, timesAmount);
    }
}
