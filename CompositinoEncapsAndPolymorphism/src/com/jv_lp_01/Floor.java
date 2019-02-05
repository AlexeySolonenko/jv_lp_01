package com.jv_lp_01;

public class Floor {
    private FireSafety fireSafety;
    private Dimensions dimensions;
    private String kind;
    private String pattern;
    private boolean heated;

    public Floor(FireSafety fireSafety, Dimensions dimensions, String kind, String pattern, boolean heated) {
        this.fireSafety = fireSafety;
        this.dimensions = dimensions;
        this.kind = kind;
        this.pattern = pattern;
        this.heated = heated;
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

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public boolean isHeated() {
        return heated;
    }

    public void setHeated(boolean heated) {
        this.heated = heated;
    }

    public FireSafety getFireSafety() {
        return fireSafety;
    }

    public void setFireSafety(FireSafety fireSafety) {
        this.fireSafety = fireSafety;
    }
}
