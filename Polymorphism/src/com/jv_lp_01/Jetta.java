package com.jv_lp_01;

public class Jetta extends Car {
    public Jetta(int cylinders, String name, boolean licensed) {
        super(cylinders, name, licensed);
    }

    @Override
    public String startEngine(){
        String msg = "Jetta's engine does not run continuously. German start only when moving technology";
        System.out.println(msg);

        return msg;
    }

    @Override
    public String accelerate(){
        String msg = "Jetta's acceleration is smooth and steady.";
        System.out.println(msg);

        return msg;
    }

    @Override
    public String brake(){
        String msg = "Jetta's german brakes are harsh, but reliable.";
        System.out.println(msg);

        return msg;
    }
}
