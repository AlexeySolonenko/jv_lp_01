package com.jv_lp_01;

import java.util.ArrayList;

/**
 * This handles additions for a burger.
 * Each burger type either defaults its bundle to
 */
public class ExtrasBundle {

    private ArrayList<Extra> extras = new ArrayList<Extra>();
    private int maxExtras = 20;

    public ArrayList<Extra> getExtras() {
        return extras;
    }

    public void addExtras(Extra addon){
        this.extras.add(addon);
    }

    public void setExtras(ArrayList<Extra> extras) {
        this.extras = extras;
    }

    public int getMaxExtras() {
        return maxExtras;
    }

    public void setMaxExtras(int maxExtras) {
        this.maxExtras = maxExtras;
    }
}
