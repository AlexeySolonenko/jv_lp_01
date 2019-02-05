package com.jv_lp_01;

public class Furniture {
    private FireSafety fireSafety;
    private Dimensions dimensions;
    private String kind;
    private int legs;
    private int doors;
    private String purpose;

    public Furniture(FireSafety fireSafety, Dimensions dimensions, String kind, int legs, int doors, String purpose) {
        this.fireSafety = fireSafety;
        this.dimensions = dimensions;
        this.kind = kind;
        this.legs = legs;
        this.doors = doors;
        this.purpose = purpose;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
    public FireSafety getFireSafety() {
        return fireSafety;
    }

    public void setFireSafety(FireSafety fireSafety) {
        this.fireSafety = fireSafety;
    }
}
