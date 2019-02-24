package com.jv_lp_01;

public class SIBtest {
    public static final String owner;

    static {
        owner = "ivan";
        System.out.println("SIB test static initiazliaation blocka called" );
    }

    public SIBtest() {
        System.out.println("SIB constructor called");
    }

    static {
        System.out.println("2nd initialization block called");
    }

    public void someMethod(){
        System.out.println("Some method called");
    }

}
