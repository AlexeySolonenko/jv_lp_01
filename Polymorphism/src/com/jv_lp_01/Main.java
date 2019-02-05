package com.jv_lp_01;

import javax.sound.midi.Soundbank;

class Movie {
    private String name;

    public Movie(String name) {
        this.name = name;
    }

    public String plot() {
        return "No plot here";
    }
    public String getName(){
        return this.name;
    }
}

class Jaws extends Movie {
    public Jaws(String name) {
        super(name);
    }

    public String plot() {
        return "A shark eats lots of people";
    }
}

class IndependenceDay extends Movie {
    public IndependenceDay() {
        super("Independence Day");
    }

    @Override
    public String plot() {
        return "Aliens attempt to take over planet earth";
    }
}

class MazeRunner extends Movie {
    public MazeRunner() {
        super("Maze Runner");
    }

    @Override
    public String plot() {
        return "Kids try to escape a maze";
    }
}

class StarWars extends Movie {
    public StarWars() {
        super("Star Wars");
    }

    @Override
    public String plot() {
        return "Imperial forces try to take over the universe";
    }
}

class ForgettableMovie extends Movie {
    public ForgettableMovie() {
        super("Forgettable");
    }
    // no plot method
}


public class Main {

    public static void main(String[] args) {

        for (int  i = 1; i < 11; i++){
            Movie movie = randomMovie();
            System.out.println("Movie #"+ i+ ": "+ movie.getName()  + "\n" +
                    "Plot: " + movie.plot() + "\n");
        }
        System.out.println("Random cars");

        for (int  i = 1; i < 11; i++){
            Car car = randomCar();
            System.out.println("Car #"+ i+ ": "+ car.getName()  + "\n" +
                    "Start engine: " + car.startEngine() + "\n"+
                    "Accelerate: " + car.accelerate() + "\n"+
                    "Brake: " + car.brake() + "\n");
        }
    }

    public static Movie randomMovie() {
        int randomNumber = (int) (Math.random() * 5 + 1);
        System.out.println("Random number generated was: " + randomNumber);
        switch (randomNumber) {
            case 1:
                return new Jaws("Jaws");
            case 2:
                return new IndependenceDay();
            case 3:
                return new MazeRunner();
            case 4:
                return new StarWars();
            case 5:
                return new ForgettableMovie();
            default:
                return null;
        }

    }

    public static Car randomCar(){
        int randomNumber = (int) (Math.random() * 3 + 1);
        System.out.println("Random number generated was: " + randomNumber);
        switch (randomNumber) {
            case 1:
                return new Jetta(4,"Jetta",true);
            case 2:
                return new Civic(4,"Civic",true);
            case 3:
                return new AbandonedCar(12,"Abandoned",false);
            default:
                return null;
        }
    }
}
