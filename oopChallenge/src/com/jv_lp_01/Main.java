package com.jv_lp_01;

public class Main {

    public static void main(String[] args) {
        Carrot carrot = new Carrot();
        Tomato tomato = new Tomato();
        Lettuce lettuce = new Lettuce();
        Cheese cheese = new Cheese(5);
        MainBurger mainBurger = new MainBurger();
        mainBurger.getExtrasBundle().addExtras(carrot);
        mainBurger.getExtrasBundle().addExtras(tomato);
        mainBurger.getExtrasBundle().addExtras(lettuce);
        mainBurger.getExtrasBundle().addExtras(cheese);

        mainBurger.getFinalPrice();

        DeluxBurger deluxBurger = new DeluxBurger();
        deluxBurger.getFinalPrice();
        /* this works, but extras are not added, deluxBurger Final Price is still same 4.55 */
        deluxBurger.getExtrasBundle().addExtras(new Carrot(1));
        deluxBurger.getExtrasBundle().addExtras(new Carrot(1));
        deluxBurger.getFinalPrice();

        DeluxBurger greedyDeluxBurger = new DeluxBurger(10,10);
        greedyDeluxBurger.getFinalPrice();
        HealthyBurger hB1 = new HealthyBurger();
        hB1.getFinalPrice();
    }
}
