package com.jv_lp_01;

public class MainBurger extends BaseHamburger {

    public MainBurger(BreadType rollType, boolean meat) {
        super(rollType, meat, 1.00);
    }

    public MainBurger(BreadType rollType, boolean meat, double price) {
        super(rollType, meat, price);
    }
}
