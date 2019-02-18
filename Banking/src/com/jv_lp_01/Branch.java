package com.jv_lp_01;

import java.util.*;
import java.util.stream.Collectors;

public class Branch {

    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private int id;
    private String name;
    private ArrayList<Integer> listedIds = new ArrayList<Integer>();
    private int indexer = 0;
    private Scanner scanner = new Scanner(System.in);

    public Branch(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void addCustomer(String name, int id){
        customers.add(new Customer(0.00,name,id));
    }
    //    public addCustomer(){
//
//    }
//    /* TODO to add all overloads */
//    public addCustomerTxs(ArrayList<Double> txs, Customer customer){
//
//    }
//
//    public addCustomerTx(double tx, Customer customer){
//
//    }
    public Customer getCustomerById(int id){
        Optional<Customer> customer = customers.stream().filter(c -> {return (c.getId() == id);}).findFirst();
        if(customer.isEmpty()) return new Customer(0.00,"Empty Customer",-1);
        else return customer.get();
    }

    public int findMaxCustomerId(){
        int maxId = customers.stream().mapToInt(Customer::getId).reduce(1,Integer::max);
        return maxId;

        //return max;
    }
    public int pickCustomer() {
        listCustomers();
        int num = scanner.nextInt();
        if(num <= 0) return 0;
        int id = this.listedIds.get(num);
        return getCustomerById(id).getId();
    }

    public void listCustomers() {
        this.indexer = 0;
        this.listedIds.clear();
        listedIds.add(0);
        System.out.println("0 - Cancel");
        customers.stream().sorted(Comparator.comparing(Customer::getName))
                .forEach(b -> {
                    this.indexer++;
                    String line = Integer.toString(this.indexer) + " - " + b.getName();
                    this.listedIds.add(b.getId());
                    System.out.println(line);
                });

        this.indexer = 0;
    }

    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * @return
     */
    public Branch setName(String name) {
        this.name = name;

        return this;
    }


    public void modifyCustomer(){
        int id = pickCustomer();
        if(id == 0){
            System.out.println("Cancelled");
            return;
        }
        Customer customer = this.getCustomerById(id);
        System.out.println("Enter new name for customer " + customer.getName() + ": ");
        String newName = scanner.next();
        customer.setName(newName);
    }

}
