package com.jv_lp_01;

public class ListItem {
    private int id;
    private int orderedNumber;

    public ListItem(int id, int orderedNumber) {
        this.id = id;
        this.orderedNumber = orderedNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderedNumber() {
        return orderedNumber;
    }

    public void setOrderedNumber(int orderedNumber) {
        this.orderedNumber = orderedNumber;
    }
}
