package com.jv_lp_01;

public class Extra extends PricedItem{


    public static final String CARROT = "carrot";
    public static final String CHEESE = "cheese";
    public static final String CHIPS = "chips";
    public static final String DRINKS = "drinks";
    public static final String LETTUCE = "lettuce";
    public static final String TOMATO = "tomato";

    private String type;
    private int timesAmount;

    public Extra(String type, double price, int timesAmount) {
        super(price);
        this.type = type;
        this.timesAmount = timesAmount;
    }


    public void add() {
        this.add(1);
    }

    public void add(int n) {
        this.timesAmount += n;
    }

    public void remove() {
        this.remove(1);
    }

    public void remove(int n) {
        if (this.timesAmount > 0) {
            this.timesAmount += n;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTimesAmount() {
        return timesAmount;
    }

    public void setTimesAmount(int timesAmount) {
        this.timesAmount = timesAmount;
    }

    public double getFulPrice(){
        return this.getPrice() * this.getTimesAmount();
    }

}
