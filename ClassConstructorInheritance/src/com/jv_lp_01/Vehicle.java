package com.jv_lp_01;

public class Vehicle {
    private int gear;
    private String name;

    public Vehicle(){
        this(1,"Default vehicle");
    }

    public Vehicle(int gear){
        this(gear,"Default vehicle");

    }

    public Vehicle(int gear, String name){
        this.gear = gear;
        this.name = name;
    }

    public void gearUp(){
        this.gear++;

    }
    public void gearDown(){
        if(this.gear > 0){
            this.gear--;
        } else {
            System.out.println("Car is on the neutral gear. ");
        }
    }

    public void gearRev(){
        this.gear = -1;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }
}
