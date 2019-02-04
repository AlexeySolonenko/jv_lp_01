package com.jv_lp_01;

public class Convertible extends RoadCar {

    private boolean roofOpen;

    public Convertible(){
        this(1, 10, "straight", true);
    }

    public Convertible(int gear, int speed, String steering, boolean roofOpen) {
        super(gear, speed, steering);
        this.roofOpen = roofOpen;
    }

    public boolean isRoofOpen() {
        return roofOpen;
    }

    public void setRoofOpen(boolean roofOpen) {
        this.roofOpen = roofOpen;
    }


}
