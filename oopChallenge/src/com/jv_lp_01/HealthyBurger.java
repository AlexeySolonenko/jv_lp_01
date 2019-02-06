package com.jv_lp_01;

public class HealthyBurger extends BaseHamburger {

    public static final double DEFAULT_PRICE = 2.00;

    public HealthyBurger(BreadType rollType, boolean meat, String name) {
        super(rollType, meat, HealthyBurger.DEFAULT_PRICE, name);
    }

    public HealthyBurger(BreadType rollType, boolean meat, double price, String name) {
        super(rollType, meat, price, name);
    }

    public HealthyBurger(BreadType rollType, boolean meat, double price, String name, Addition addon1, Addition addon2) {
        super(rollType, meat, price, name);
        this.setAddon1(addon1);
        this.setAddon2(addon2);
    }

    public HealthyBurger(BreadType rollType, boolean meat, String name, Addition addon1, Addition addon2) {
        super(rollType, meat, HealthyBurger.DEFAULT_PRICE,name);
        this.setAddon1(addon1);
        this.setAddon2(addon2);
    }

    /* Here we are making 4 extras publicly available for addition */
    @Override
    public void setAddon3(Addition addon3) {
        super.setAddon3(addon3);
    }

    @Override
    public void setAddon4(Addition addon4) {
        super.setAddon3(addon4);
    }

    @Override
    public void setAddon5(Addition addon5) {
        super.setAddon3(addon5);
    }

    @Override
    public void setAddon6(Addition addon6) {
        super.setAddon3(addon6);
    }
}
