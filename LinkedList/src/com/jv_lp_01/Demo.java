package com.jv_lp_01;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();
        addInOrder(placesToVisit,"Sydney");
        addInOrder(placesToVisit,"Melbourne");
        addInOrder(placesToVisit,"Brisbane");
        addInOrder(placesToVisit,"Perth");
        addInOrder(placesToVisit,"Canberra");
        addInOrder(placesToVisit,"Adelaide");
        addInOrder(placesToVisit,"Alice Springs");
        addInOrder(placesToVisit,"Darwin");
        addInOrder(placesToVisit,"Darwin");


//        placesToVisit.add("Sydney");
//        placesToVisit.add("Melbourne");
//        placesToVisit.add("Brisbane");
//        placesToVisit.add("Perth");
//        placesToVisit.add("Canberra");
//        placesToVisit.add("Adelaide");
//        placesToVisit.add("Darwin");

        printList(placesToVisit);
        placesToVisit.add(1,"Alice Sprints");
        printList(placesToVisit);
        placesToVisit.remove(4);
        printList(placesToVisit);
        visit(placesToVisit);
    }

    private static void printList(LinkedList<String> linkedList){
        Iterator<String> i = linkedList.iterator();
        while(i.hasNext()){
            System.out.println("Now visiting " + i.next() );
        }
        System.out.println("=======================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity){
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while(stringListIterator.hasNext()){
            /* Important - just ot arrive toe the first element you need next() */
            int comparision = stringListIterator.next().compareTo(newCity);
            if(comparision == 0){
                /* equal, do not add */
                System.out.println(newCity + " is already incliuded as a destination" );
            } else if(comparision > 0){
                /* new city shoudl appear before thes one */
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else if (comparision < 0){
                /* move on next city */

            }

        }
        stringListIterator.add(newCity);
        return true;

    }

    private static void visit(LinkedList cities){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        ListIterator<String> listIterator = cities.listIterator();
        if(cities.isEmpty()){

        } else {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }
        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            boolean goingForward = true;
            switch(action){
                case 0:
                    System.out.println("Holiday (Vacation) over");
                    quit = true;
                    break;
                case 1:
                    if(!goingForward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now visitigng " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list");
                        goingForward=false;
                    }
                    break;
                case 2:
                    if(goingForward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now visitigng " + listIterator.previous());
                    } else {
                        System.out.println("Reached the start of the list");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }
    }

    public static void printMenu(){
        System.out.println("Avaialble action:\npress");
        System.out.println("0 - to quit\n1 - to go to next city\n2 - to go to previous city\n3 - print menu options ");

    }
}
