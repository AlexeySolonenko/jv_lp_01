package com.jv_lp_01;

public class DeluxBurger extends RootHamburger {


    public DeluxBurger(){
        this(1,1);
    }

    public DeluxBurger(int drinks, int chips){
        this(1.25, drinks, chips);
    }

    public DeluxBurger(double price,int drinks, int chips) {
        this(price, new WhiteBunBread(),drinks,chips);
    }

    public DeluxBurger(double price,BreadType rollType,int drinks, int chips) {
        this(price, 1.50, rollType, drinks, chips);
    }

    public DeluxBurger(double price, double meatPrice,BreadType rollType,int drinks, int chips) {
        this(price, true,meatPrice, rollType, drinks, chips);
    }

    public DeluxBurger(double price, boolean meat, double meatPrice,  BreadType rollType,int drinks, int chips) {
        super(price, false, meat, meatPrice, "Delux Burger", rollType);
        super.getExtrasBundle().addExtras(new Drinks(drinks));
        super.getExtrasBundle().addExtras(new Chips(chips));
        this.setExtrasLocked(true);
    }

}
