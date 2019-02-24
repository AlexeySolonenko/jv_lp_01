package com.jv_lp_01;

import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final BodyTypes bodyType;

    public enum BodyTypes{
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID,

    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        satellites = new HashSet<HeavenlyBody>();
        this.bodyType = bodyType;
    }

    public boolean addMoon(HeavenlyBody moon){
        return this.satellites.add(moon);
    }
    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<HeavenlyBody>(satellites);
    }

    public  BodyTypes getBodyType() {
        return this.bodyType;
    }

    @Override
    public final boolean equals(Object obj){
        if(this == obj){
            return true;
        }
//        System.out.println("obj.getClass() is " + obj.getClass());
//        System.out.println("this.getGlass  " + this.getClass());
//        if ((obj == null) || (obj.getClass() != this.getClass())){
//            return false;
//        }

        String objName = ((HeavenlyBody) obj).getName();
        BodyTypes objType = ((HeavenlyBody) obj).getBodyType();
        if(this.name.equals(objName)){
            if(this.getBodyType() == ((HeavenlyBody)obj).getBodyType()){
                return true;
            }
        }

        return false;
    }


    @Override
    public final int hashCode() {
        //System.out.println("Hash code called");
        /* call string hashcode */
        /* +57 to be non-zero*/
        return this.name.hashCode() + 57 + this.bodyType.hashCode();
    }

    @Override
    public String toString(){
        return this.name + ": " + this.bodyType + ", " + this.orbitalPeriod;
    }
}
