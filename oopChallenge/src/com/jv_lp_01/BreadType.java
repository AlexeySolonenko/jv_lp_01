package com.jv_lp_01;

public class BreadType extends PricedItem {

    private String type;

    public BreadType(double price, String type) {
        super(price);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
