package com.jv_lp_01;

public class RoadCar extends Vehicle {

    private int speed;
    private String steering;

    public RoadCar(){
        this(1, 2, "straight");
    }

    public RoadCar(int speed, String steering){
        super();
        this.speed = speed;
        this.steering = steering;
    }
    public RoadCar(int gear, int speed, String steering) {
        super(gear);
        this.steering = steering;
        this.speed = speed;
    }

    public void accelerate(){
        speed ++;
    }
    public RoadCar decelerate(){
        if(speed == 0){
            System.out.println("Road Car is still");
        } else {
            speed--;
        }
        return this;
    }
    public int getSpeed() {
        return speed;
    }

    public String getSteering() {
        return steering;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setSteering(String steering) {
        this.steering = steering;
    }
}
