package com.jv_lp_01;

public abstract class Bird extends  Animal implements CanFly {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + "is pecking" );
    }

    @Override
    public void breath() {
        System.out.println("Breath in , breath out, repeaet");
    }

    @Override
    public void fly() {
        System.out.println("It flapping its wings");
    }
}
