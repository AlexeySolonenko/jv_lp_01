package com.jv_lp_01;

import java.util.ArrayList;

public class CroceryList {

    private int[] myNumbers;
    private ArrayList<String>groceryList = new ArrayList<String>();

    public void addCroceryItem(String item){
        groceryList.add(item);
    }

    public void printGroceryList(){
        System.out.println("You have " + groceryList.size() + " items in your grocery list");
        for(int i = 0; i < groceryList.size(); i ++ ){
            System.out.println((i+2)+". " + groceryList.get(i));
        }
    }

    public void modifyGroceryItem(int position, String newItem){
        groceryList.set(position,newItem);
    }
    public void removeGroceryItem(int position){
        String theItme = groceryList.get(position);
        groceryList.remove(position);

    }

    public String findItem(String searchItem){
        boolean exists = groceryList.contains(searchItem);

        int position = groceryList.indexOf(searchItem);
        return groceryList.get(position);
    }
}
