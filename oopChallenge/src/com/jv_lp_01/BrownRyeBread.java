package com.jv_lp_01;

public class BrownRyeBread extends BreadType {

    public BrownRyeBread(){
        this(2.20);
    }
    public BrownRyeBread(double price) {
        super(price, "Brown Rye Bread");
    }
}
