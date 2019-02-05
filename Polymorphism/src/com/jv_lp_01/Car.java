package com.jv_lp_01;

public class Car {
    private String color = "White";
    private int cylinders = 12;
    private String engine = "Twincam";
    private String fuel = "Gasoline";
    private int hp = 235;
    private boolean licensed = false;
    private String name = "Corolla RT";
    private int wheels = 4;


    public Car(int cylinders, String name, boolean licensed) {
        if (cylinders < 24 && cylinders > 2) {
            this.cylinders = cylinders;
        }
        this.name = name;
        this.licensed = licensed;
    }

    public Car(String color, int cylinders, String engine, String fuel, int hp, boolean licensed, String name, int wheels) {
        this.color = color;
        this.cylinders = cylinders;
        this.engine = engine;
        this.fuel = fuel;
        this.hp = hp;
        this.licensed = licensed;
        this.name = name;
        this.wheels = wheels;
    }


    public String startEngine() {
        String msg = "Engine of " + this.name + " is running";
        System.out.println(msg);

        return msg;
    }

    public String accelerate() {
        String msg = this.name + " is accelerating";
        System.out.println(msg);

        return msg;
    }

    public String brake() {
        String msg =this.name + " is braking.";
        System.out.println(msg);
        return msg;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isLicensed() {
        return licensed;
    }

    public void setLicensed(boolean licensed) {
        this.licensed = licensed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }
}
