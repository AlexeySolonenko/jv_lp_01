package com.jv_lp_01;

import javax.swing.plaf.synth.SynthTabbedPaneUI;

public class Dog extends Animal {

    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;


    public Dog(String name, int brain, int body, int size, int weight, int eyes, int teeth, int legs, int tail, String coat ) {
        super(name, 1, 1, size, weight);
//        this.eyes = 2;
//        this.legs = 4;
//        this.tail = 1;
//        this.teeth = 24;
//        this.coat = "white";
                this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }

    @Override
    public void eat() {
        System.out.println("Dog.eat() called");
        chew();
        super.eat();
    }

    public void walk(){
        System.out.println("Dog.walk() called");
        super.move(5);
    }
    public void run(){
        System.out.println("Dog.run() called");
        this.move(10);
    }
    public void moveLegs(int speed){
        System.out.println("Dog.moveLegs() called");
    }
    @Override
    public void move(int speed){
        System.out.println("Dog.move() called");
        moveLegs(speed);
        super.move(speed);
    }

    private void chew(){
        //super.eat();
        System.out.println("Dog.chew() called");
    }
}
