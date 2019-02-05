package com.jv_lp_01;

public class DeluxBurger extends MainBurger {

    public DeluxBurger(BreadType rollType, boolean meat) {
        super(rollType, meat);
        this.setAddon1(new Chips());
        this.setAddon1(new Drinks());
    }
}
