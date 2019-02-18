package com.jv_lp_01;

import org.w3c.dom.Node;

public class Main {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList(null);
        list.traverse(list.getRoot());
        String stringData = "Moscow SPeterburg Kirov Moscow Krasnoyarsk Omsk Ork Novosibirsk Kaliningrad";
        stringData = "1 2 3 4 5 6 7 8 9";
        String[] data = stringData.split(" ");
        for(String s : data){
            Item item = new Item(s);
            list.addItem(item);
        }
        list.traverse(list.getRoot());
        list.removeItem(new Item("3"));
        list.traverse(list.getRoot());
        list.removeItem(new Item("10"));
        list.traverse(list.getRoot());
        list.removeItem(new Item("4"));
        list.traverse(list.getRoot());
        list.removeItem(new Item("7"));
    }
}
