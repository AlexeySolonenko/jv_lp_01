package com.jv_lp_01;

public class MainBurger extends BaseHamburger {

    public MainBurger() {
        this(true);
    }

    public MainBurger(boolean meat) {
        this(new WhiteBunBread(), meat);
    }


    public MainBurger(BreadType rollType, boolean meat) {
        this(rollType, meat, 1.00, "Smart Choice Burger ");
    }

    public MainBurger(BreadType rollType, boolean meat, String name) {
        this(rollType, meat, 1.00, name);
    }

    public MainBurger(BreadType rollType, boolean meat, double price, String name) {
        super(rollType, meat, price, name);
    }


}
