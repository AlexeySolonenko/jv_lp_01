package com.jv_lp_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Player ivan = new Player("Ivan", 10, 15);
        System.out.println(ivan.toString());

        ivan.setHitPoints(8);
        System.out.println(ivan);
        ivan.setWeapon("Stormbringer");
        saveObject(ivan);
        loadObject(ivan);
        System.out.println(ivan);

        ISaveable werewolf = new Monster("Werewolf",20,40);
        /* does not work */
        //werewolf.getStrength();
        /* does work */
        ((Monster) werewolf).getStrength();
        System.out.println(werewolf);
        saveObject(werewolf);


    }

public static ArrayList readValues(){
        ArrayList<String> values = new ArrayList<String>();
    Scanner scanner = new Scanner(System.in);
    boolean quit = false;
    int index = 0;
    System.out.println("Choose\n1 to enter a string\n0 to quit");
    while(!quit){
        System.out.println("Choose and opiotn: " );
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch(choice){
            case 0:
                quit  = true;
                break;
            case 1:
                System.out.println("Enter a string: ");
                String stringInput = scanner.nextLine();
                values.add(index, stringInput);
                index++;
                break;
        }
    }

    return values;
}

    public static void saveObject(ISaveable objectToSave){
        for(int i = 0; i < objectToSave.write().size(); i++){
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage system" );
        }
    }

    public static void loadObject(ISaveable objecToLoad){
        ArrayList<String> values = readValues();
        objecToLoad.read(values);
    }
}
