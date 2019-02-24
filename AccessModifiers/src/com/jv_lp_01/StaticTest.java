package com.jv_lp_01;

public class StaticTest {

    private static int numInstances = 0;
    private String name;

    public StaticTest(String name) {
        this.name = name;
        numInstances++;
    }

    public static int getNuminstances(){
        return numInstances;
    }
    public int getNumInstances() {
        return numInstances;
    }

    public String getName() {

        return name;
    }
}
