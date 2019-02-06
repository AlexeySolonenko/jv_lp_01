package com.jv_lp_01;

public class DeluxBurger extends BaseHamburger {

    /**
     * Has no public methods to set extra additions
     * Chips and Drinks are initiated in the system separately
     *
     * @param rollType
     * @param price
     * @param meat
     */
    public DeluxBurger(BreadType rollType, double price, boolean meat) {
        super(rollType, meat, price, "Delux Burger");
        this.setAddon1(new Chips());
        this.setAddon1(new Drinks());
    }

    /**
     *
     * @param rollType
     * @param meat
     */
    public DeluxBurger(BreadType rollType, boolean meat) {
        super(rollType, meat, 2.40, "Delux Burger");
        this.setAddon1(new Chips());
        this.setAddon1(new Drinks());
    }
}
