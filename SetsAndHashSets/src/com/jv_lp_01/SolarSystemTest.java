package com.jv_lp_01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolarSystemTest {

    private static Set<HeavenlyBody> solarSystem = new HashSet<HeavenlyBody>();
    private static Set<HeavenlyBody> planets = new HashSet<HeavenlyBody>();

    /*
        MY SOL;UTION WORKS, BUT ITS CRAP - STUDIED AND DOWNLOADED THE LESSON SOLUTION

     */

    public static void main(String[] args) {
        initSystem();

        Star tempStar = new Star("Mercury",20);
        solarSystem.add(tempStar);
        tempStar = new Star("Mercury",20);
        solarSystem.add(tempStar);

        System.out.println("All Objects");
        for(HeavenlyBody body : solarSystem) {
            System.out.println("\t" + body.getName() + ":\t"+body.getBodyType());
        }

        HeavenlyBody body = getBodyByNameAndType("Mars","planet");
        System.out.println("Moons of " + body.getName());
        for(HeavenlyBody jupiterMoon: body.getSatellites()) {
            System.out.println("\t" + jupiterMoon.getName());
        }

        Set<HeavenlyBody> moons = new HashSet<>();
        for(HeavenlyBody planet : planets) {
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All Moons");
        for(HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getName());
        }
        HeavenlyBody earth1 = new Planet("Earth",365);
        HeavenlyBody earth2 = new Planet("Earth",365);
        System.out.println(earth1.equals(earth2));
        System.out.println(earth2.equals(earth1));

    }


    public static void initSystem(){
        Planet temp = new Planet("Mercury", 88);
        solarSystem.add(temp);
        planets.add(temp);

        temp = new Planet("Venus", 225);
        solarSystem.add(temp);
        planets.add(temp);

        temp = new Planet("Earth", 365);
        solarSystem.add(temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new Moon("Moon", 27);
        solarSystem.add(tempMoon);
        temp.addMoon(tempMoon);

        temp = new Planet("Mars", 687);
        solarSystem.add(temp);
        planets.add(temp);

        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.add(tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.add(tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        temp = new Planet("Jupiter", 4332);
        solarSystem.add(temp);
        planets.add(temp);

        tempMoon = new Moon("Io", 1.8);
        solarSystem.add(tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.add(tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.add(tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.add(tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        temp = new Planet("Saturn", 10759);
        solarSystem.add(temp);
        planets.add(temp);

        temp = new Planet("Uranus", 30660);
        solarSystem.add(temp);
        planets.add(temp);

        temp = new Planet("Neptune", 165);
        solarSystem.add(temp);
        planets.add(temp);

        temp = new Planet("Pluto", 248);
        solarSystem.add(temp);
        planets.add(temp);
    }

    public static HeavenlyBody getBodyByNameAndType(String name, String type){
        for(HeavenlyBody body : solarSystem){
            if(body.getName().equals(name) && body.getBodyType().equals(type)){
                return body;
            }
        }
        return new HeavenlyBody("",0, HeavenlyBody.BodyTypes.PLANET);
    }
}
