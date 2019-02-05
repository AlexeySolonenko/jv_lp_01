package com.jv_lp_01;

public class PricedItem {

    private double price;

    public PricedItem(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public PricedItem setPrice(double price) {
        this.price = price;

        return this;
    }
}
