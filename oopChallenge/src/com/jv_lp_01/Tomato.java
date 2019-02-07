package com.jv_lp_01;

public class Tomato extends Extra {

    public Tomato() {
        this(1);
    }

    public Tomato(int timesAmount) {
        this(0.25,timesAmount);
    }

    public Tomato(double price, int timesAmount) {
        super(Extra.TOMATO, price, timesAmount);
    }
}
