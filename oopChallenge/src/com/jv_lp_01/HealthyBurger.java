package com.jv_lp_01;

public class HealthyBurger extends MainBurger {

    public HealthyBurger(BreadType rollType, boolean meat, Addition addon1, Addition addon2) {
        super(rollType, meat, 2.00);
        this.setAddon1(addon1);
        this.setAddon2(addon2);
    }

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
