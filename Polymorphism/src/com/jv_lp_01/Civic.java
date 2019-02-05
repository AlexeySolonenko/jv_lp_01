package com.jv_lp_01;

public class Civic extends Car {
    public Civic(int cylinders, String name, boolean licensed) {
        super(cylinders, name, licensed);
    }

    @Override
    public String startEngine(){
        String msg = "Civic's is a race start - fell the hummmm";
        System.out.println(msg);

        return msg;
    }

    @Override
    public String accelerate(){
        String msg = "Civic's takes off.";
        System.out.println(msg);

        return msg;
    }

    @Override
    public String brake(){
        String msg = "Civic's brakes wildly, in a fit to its accelaration .";
        System.out.println(msg);

        return msg;
    }
}
