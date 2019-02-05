package com.jv_lp_01;


public class WhiteBunBread extends BreadType {

    public WhiteBunBread(){
        this(0.75);
    }

    public WhiteBunBread(double price) {
        super(price, "White Bun Bread");
    }
}