package com.jv_lp_01;

public class Door {
    private FireSafety fireSafety;
    private Dimensions dimensions;
    private String color;
    private String lock;
    private int securityLevel;
    private boolean withEye;

    public Door(FireSafety fireSafety, Dimensions dimensions, String color, String lock, int securityLevel, boolean withEye) {
        this.fireSafety = fireSafety;
        this.dimensions = dimensions;
        this.color = color;
        this.lock = lock;
        this.securityLevel = securityLevel;
        this.withEye = withEye;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLock() {
        return lock;
    }

    public void setLock(String lock) {
        this.lock = lock;
    }

    public int getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(int securityLevel) {
        this.securityLevel = securityLevel;
    }

    public boolean isWithEye() {
        return withEye;
    }

    public void setWithEye(boolean withEye) {
        this.withEye = withEye;
    }
    public FireSafety getFireSafety() {
        return fireSafety;
    }

    public void setFireSafety(FireSafety fireSafety) {
        this.fireSafety = fireSafety;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }
}
