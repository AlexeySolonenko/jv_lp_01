package com.jv_lp_01;

public class HealthyBurger extends RootHamburger {

    /* sad truth, healthy gets charged */
    public static final double DEFAULT_PRICE = 2.00;


    public HealthyBurger( ) {
        this(new Cheese());
    }

    public HealthyBurger(Extra extra2 ) {
        this(new Drinks(), extra2);
    }

    public HealthyBurger(Extra extra1, Extra extra2 ) {
        this(HealthyBurger.DEFAULT_PRICE, extra1, extra2);
    }

    public HealthyBurger(double price, Extra extra1, Extra extra2) {
        this(price,  1.50, extra1, extra2);
    }

    public HealthyBurger(double price,  double meatPrice, Extra extra1, Extra extra2) {
        this(price, true, meatPrice, extra1, extra2);
    }

    public HealthyBurger(double price,  boolean meat, double meatPrice, Extra extra1, Extra extra2) {
        super(price, false, meat, meatPrice, "Healthy Burger", new BrownRyeBread());
        super.getExtrasBundle().addExtras(extra1);
        super.getExtrasBundle().addExtras(extra2);
    }
}
