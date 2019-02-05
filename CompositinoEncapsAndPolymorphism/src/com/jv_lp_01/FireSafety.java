package com.jv_lp_01;

public class FireSafety {
    private int flameResistance;
    private String resistanceGroup;
    private int flashPoint;

    public FireSafety(int flameResistance, String resistanceGroup, int flashPoint) {
        this.flameResistance = flameResistance;
        this.resistanceGroup = resistanceGroup;
        this.flashPoint = flashPoint;
    }

    public int getFlameResistance() {
        return flameResistance;
    }

    public void setFlameResistance(int flameResistance) {
        this.flameResistance = flameResistance;
    }

    public String getResistanceGroup() {
        return resistanceGroup;
    }

    public void setResistanceGroup(String resistanceGroup) {
        this.resistanceGroup = resistanceGroup;
    }

    public int getFlashPoint() {
        return flashPoint;
    }

    public void setFlashPoint(int flashPoint) {
        this.flashPoint = flashPoint;
    }
}
