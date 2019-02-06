package com.jv_lp_01;

public class PricedItem {

    /**
     * @var double price
     */
    private double price;

    /**
     * @param price
     */
    public PricedItem(double price) {
        this.price = price;
    }

    /**
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price
     * @return
     */
    public PricedItem setPrice(double price) {
        this.price = price;

        return this;
    }
}
