package com.jv_lp_01;

public class BaseHamburger extends PricedItem {

    public static final String RIGHTS_HOLDER = "Bills Burgers";


    private BreadType rollType;
    private boolean meat;

    private double meatPrice = 2.50;
    /* todo to convert into array */
    private Addition addon1;
    private Addition addon2;
    private Addition addon3;
    private Addition addon4;
    private Addition addon5;
    private Addition addon6;

    public BaseHamburger() {
        super(3.20);
    }


    public BaseHamburger(BreadType rollType, boolean meat, double price) {
        super(price);
        this.rollType = rollType;
        this.meat = meat;
    }

    public double getFinalPrice() {
        double price = 0.0;
        price += this.rollType.getPrice();
        price += this.addon1.getFulPrice();
        price += this.addon2.getFulPrice();
        price += this.addon3.getFulPrice();
        price += this.addon4.getFulPrice();
        if (this.getMeat()) price += this.getMeatPrice();

        return price;
    }

    public static String getRightsHolder() {
        return RIGHTS_HOLDER;
    }

    public BreadType getRollType() {
        return rollType;
    }

    public void setRollType(BreadType rollType) {
        this.rollType = rollType;
    }

    public boolean getMeat() {
        return meat;
    }

    public void setMeat(boolean meat) {
        this.meat = meat;
    }

    public Addition getAddon1() {
        return addon1;
    }

    protected void setAddon1(Addition addon1) {
        this.addon1 = addon1;
    }

    public Addition getAddon2() {
        return addon2;
    }

    protected void setAddon2(Addition addon2) {
        this.addon2 = addon2;
    }

    public Addition getAddon3() {
        return addon3;
    }

    protected void setAddon3(Addition addon3) {
        this.addon3 = addon3;
    }

    public Addition getAddon4() {
        return addon4;
    }

    protected void setAddon4(Addition addon4) {
        this.addon4 = addon4;
    }

    public Addition getAddon5() {
        return addon5;
    }

    public void setAddon5(Addition addon5) {
        this.addon5 = addon5;
    }

    public Addition getAddon6() {
        return addon6;
    }

    public void setAddon6(Addition addon6) {
        this.addon6 = addon6;
    }

    public double getMeatPrice() {
        return meatPrice;
    }

    public void setMeatPrice(double meatPrice) {
        this.meatPrice = meatPrice;
    }
}
