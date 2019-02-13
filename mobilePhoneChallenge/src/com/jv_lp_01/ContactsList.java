package com.jv_lp_01;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactsList {

    private ArrayList<Contact> contacts = new ArrayList<Contact>();
    private ArrayList<ListItem> list = new ArrayList<ListItem>();
    private Scanner scanner = new Scanner(System.in);

    public ContactsList() {

    }

    public void addContact() {
        System.out.println("Enter Name: \n");
        String name = scanner.next();
        System.out.println("Enter Number: \n");
        int number = scanner.nextInt();
        Contact contact = new Contact(findMaxContactId() + 1, name, number);
        contacts.add(contact);
        System.out.println("Added successfully \n");

    }

    public int findMaxContactId() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getId() > max) {
                max = contacts.get(i).getId();
            }
        }
        return max;
    }

    public Contact getContactById(int id){
        Contact contact = new Contact();
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getId() == id) {
                contact = contacts.get(i);
            }
        }

        return contact;
    }
    public void modifyContact() {
        int id = selectContact();
        Contact contact= getContactById(id);
        System.out.println("Would you like to change name (y/n)?:");
        String reply = scanner.next();
        System.out.println(reply);
        System.out.println(reply.getClass());
        String name = contact.getName();
        if(reply.equals("y")){
            System.out.println("Enter new name: ");
            name = scanner.next();
        }
        System.out.println("Would you like to change number (y/n)?:");
        int number = contact.getNumber();
        reply = scanner.next();
        if(reply.equals("y")){
            System.out.println("Enter new number: ");
            number = scanner.nextInt();
        }
        for(int i = 0; i < contacts.size();i++){
            if(contacts.get(i).getId() == id){
                contacts.get(i).setName(name);
                        contacts.get(i).setNumber(number);
            }
        }
        System.out.println("Updated successfully");
        printContacts();
        printMenu();
    }

    public void openContact(){
        int id = selectContact();
        Contact contact = getContactById(id);
        System.out.println("Name: "+ contact.getName());
        System.out.println("Number: "+ contact.getNumber());

    }
    public int pickContact(String name) {
        int id = -1;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName() == name) {
                id = contacts.get(i).getId();
            }
        }

        return id;
    }

    public void printContacts() {
        list.clear();
        System.out.println("0 - Exit");
        for (int i = 0; i < contacts.size(); i++) {
            list.add(new ListItem(contacts.get(i).getId(), i));
            System.out.println((i + 1) + " - " + contacts.get(i).getName());
        }
    }

    public void printMenu() {
        System.out.println("\nSelect an option:");
        System.out.println("1 - List Contacts");
        System.out.println("2 - Open Contact");
        System.out.println("3 - Add Contact");
        System.out.println("4 - Modify Contact");
        System.out.println("5 - Remove Contact");
        System.out.println("6 - Exit \n");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                printContacts();
                printMenu();
                break;
            case 2:
                openContact();
                break;
            case 3:
                addContact();
                break;
            case 4:
                modifyContact();
                break;
            case 5:
                removeContact();
                break;
            case 6:
                return;
                /* exit */
            default:
                return;
        }
        printMenu();
    }

    public void removeContact() {
        int id = selectContact();
        for(int i = 0; i < contacts.size();i++){
            if(contacts.get(i).getId() == id){
                contacts.remove(i);
            }
        }
    }

    public int selectContact() {
        printContacts();
        int option = scanner.nextInt();
        int id = -1;
        if (option == 0) return -1;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getOrderedNumber()+1 == option){
                id = list.get(i).getId();
            }
        }
        return id;
    }


//    public ArrayList<Contact> getContacts() {
//        return contacts;
//    }
//
//    public void setContacts(ArrayList<Contact> contacts) {
//        this.contacts = contacts;
//    }
}
