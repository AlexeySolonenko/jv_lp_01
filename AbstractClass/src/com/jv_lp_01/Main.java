package com.jv_lp_01;

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog("Yorkie");
        dog.breath();
        dog.eat();
        Parrot parrot = new Parrot("Australian ringneck");
        parrot.breath();
        parrot.eat();
        parrot.fly();
        Pinguin pinguin = new Pinguin("Emperor");
        pinguin.fly();
    }
}
