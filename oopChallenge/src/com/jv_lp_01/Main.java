package com.jv_lp_01;

import java.util.TooManyListenersException;

public class Main {

    public static void main(String[] args) {
	Carrot carrot = new Carrot();
	Tomato tomato = new Tomato();
	Lettuce lettuce = new Lettuce();
	Cheese cheese = new Cheese(5);
	MainBurger mainBurger = new MainBurger();

	mainBurger.getFinalPrice();
	mainBurger.getName();
    }
}
