package com.jv_lp_01;

import java.util.ArrayList;

public class Gearbox {
    private ArrayList<Gear> gears;
    private int maxGears;
    private int currentGear = 0;

    private boolean cluthIsIn;

    public Gearbox( int maxGears) {
        this.gears = new ArrayList<Gear>();
        this.maxGears = maxGears;
        this.currentGear = currentGear;
        Gear neutral = new Gear(0, 0.0);
        this.gears.add(neutral);
        for(int i = 0; i < maxGears; i++){
            addGear(i, i* 5.3);
        }
    }

    public void operateClutch(boolean in){
        this.cluthIsIn = in;
    }

    public void addGear(int number, double ratio){
        if((number > 0) && (number <= maxGears)){
            this.gears.add(new Gear (number, ratio));
        }
    }

    public void changeGear(int newGear){
        if((newGear >= 0) && (newGear < this.gears.size()) && this.cluthIsIn){
            this.currentGear = newGear;
            System.out.println("Gear " + newGear + " selected.");

        } else {
            System.out.println("Grind!");
            this.currentGear = 0;
        }

    }
    public double wheelSpeed(int revs){
        if(cluthIsIn){
            System.out.println("Scream!!!");
            return 0.0;
        } else {
            return revs * gears.get(currentGear).getRatio();
        }
    }
    private class Gear {
        private int gearNumber;
        private double ratio;

        public Gear(int gearNumber, double ratio) {
            this.gearNumber = gearNumber;
            this.ratio = ratio;
        }

        public double driveSpeed(int revs){
            return revs * (this.ratio);
        }

        public int getGearNumber() {
            return gearNumber;
        }

        public void setGearNumber(int gearNumber) {
            this.gearNumber = gearNumber;
        }

        public double getRatio() {
            return ratio;
        }

        public void setRatio(double ratio) {
            this.ratio = ratio;
        }
    }


}
