package com.jv_lp_01;

import java.util.ArrayList;

/**
 * This handles additions for a burger.
 * Each burger type either defaults its bundle to
 */
public class AddonBundle {

    private ArrayList<Addition> addons;

    public ArrayList<Addition> getAddons() {
        return addons;
    }

    public void addAddons(Addition addon){
        this.addons.add(addon);
    }

    public void setAddons(ArrayList<Addition> addons) {
        this.addons = addons;
    }
}
