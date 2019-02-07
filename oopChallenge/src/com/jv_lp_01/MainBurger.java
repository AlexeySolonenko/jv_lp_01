package com.jv_lp_01;

public class MainBurger extends RootHamburger {

    public MainBurger() {
        this(0.65);
    }

    public MainBurger(double price) {
        this(price, new WhiteBunBread());
    }


    public MainBurger(double price, BreadType rollType) {
        this(price, 1.50,rollType);
    }

    public MainBurger(double price, double meatPrice, BreadType rollType) {
        this(price, true,meatPrice,rollType);
    }

    public MainBurger(double price, boolean meat, double meatPrice,BreadType rollType) {
        super(price, false, meat, meatPrice, "Smart Choise Burger",rollType);
        /* default, can be overriden if required  */
        super.getExtrasBundle().setMaxExtras(4);
    }

}
