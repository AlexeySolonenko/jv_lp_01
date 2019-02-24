package com.jv_lp_01;

import java.net.http.HttpResponse;

public class Planet extends HeavenlyBody {
    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.PLANET);
    }

    @Override
    public boolean addMoon(HeavenlyBody moon) {
        //if(moon instanceof Moon){
        if(moon.getBodyType() == BodyTypes.MOON){
            return super.addMoon(moon);
        } else {
            return false;
        }

    }
}
