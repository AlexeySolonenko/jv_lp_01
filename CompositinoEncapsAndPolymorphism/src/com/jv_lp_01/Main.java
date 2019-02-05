package com.jv_lp_01;

public class Main {

    public static void main(String[] args) {

        Dimensions dimensions = new Dimensions(20, 20, 5);
        Case theCase = new Case("220B","240","Dell",dimensions);
        Monitor theMonitor = new Monitor("27inch Beast", "Acer", 27, new Resolution(2540,1440));
        Motherboard theMotherboard = new Motherboard("BJ-200","Asus",4,6,"v.244");
        PC thePC = new PC(theCase,theMonitor,theMotherboard);

//        thePC.getMonitor().drawPixelAt(10,10,"red");
//        thePC.getMotherboard().loadProgram("Windows 1.0");
//        thePC.getTheCase().pressPowerButton();
            thePC.powerUp();

        FireSafety floorFireSafety = new FireSafety(10, "F5",145);
        FireSafety doorFireSafety = new FireSafety(7, "F5",250);
        FireSafety furnitureFireSafety = new FireSafety(2, "F5",200);
        Dimensions floorDimensions = new Dimensions(3300,2450,20);
        Dimensions doorDimensions = new Dimensions(1400,2150,45);
        Dimensions furnitureDimensions = new Dimensions(1400,2250,450);
        Floor floor = new Floor(floorFireSafety,floorDimensions,"wood2","checkered",false);
        Furniture furniture = new Furniture(furnitureFireSafety,furnitureDimensions,"cupboard",6,12,"Storage");
        Door door = new Door(doorFireSafety,doorDimensions,"brown","Legazza",7,true);
        Room room = new Room(furniture,floor,door,"highway view");
        System.out.println("Lowest fire resistance level: "+ room.findLowestFireResistance());
        System.out.println("Lowest fire flash point : "+room.findLowestFlashPoint());

        Player player = new Player();
        player.name = "Bob";
        player.health = 20;
        player.weapon = "Sword";
        int damage = 10;
        player.loseHealth(damage);
        System.out.println("Remaning health = " + player.healthRemaining());
        damage = 11;
        //player.health = 200;
        player.loseHealth(damage);
        System.out.println("Remaning health = " + player.healthRemaining());

        EnhancedPlayer ePlayer = new EnhancedPlayer("Robin",200,"Sword");
        System.out.println("Initial health is " + ePlayer.getHealth());

        Printer printer = new Printer(10,true);
        printer.printPage(5);
        printer.printPage(1);
        printer.refillToner();
        printer.printPage(100);
        printer.printPage(5);





    }
}
