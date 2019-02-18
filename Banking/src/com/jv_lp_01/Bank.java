package com.jv_lp_01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Bank {

    ArrayList<Branch> branches = new ArrayList<Branch>();
    ArrayList<Integer> listedIds = new ArrayList<Integer>();
    private int indexer = 0;
    private Scanner scanner = new Scanner(System.in);


    public void addBranch(){
        System.out.println("Enter new branch name:");
        branches.add(new Branch(scanner.next(),findMaxBranchId()+1));
        mainMenu();
    }

    public void addBranch(String name){
        branches.add(new Branch(name,findMaxBranchId()+1));
    }

    public void addCustomer() {
        int branchId = pickBranch();
        System.out.println("Enter customer name: ");
        getBranchById(branchId).addCustomer(scanner.next(),findMaxCustomerId() + 1);
        mainMenu();
    }
    public void addTransaction(){
        Branch branch = getBranchById(pickBranch());
        branch.getCustomerById(branch.pickCustomer()).addTransactions();
        mainMenu();
    }
    private int findMaxBranchId(){
        return branches.stream().map(b -> {return b.getId();}).reduce(1,Integer::max);
    }
    private int findMaxCustomerId() {
        return branches.stream().map(b -> {
            return b.findMaxCustomerId();
        }).reduce(1, Integer::max);
    }

    public int pickBranch() {
        listBranches();
        int num = scanner.nextInt();
        if(num <= 0) return 0;
        int id = this.listedIds.get(num);
        return getBranchById(id).getId();
    }

    public void listBranches() {
        this.indexer = 0;
        this.listedIds.clear();
        listedIds.add(0);
        System.out.println("0 - Cancel");
        branches.stream().sorted(Comparator.comparing(Branch::getName))
                .forEach(b -> {
                    this.indexer++;
                    String line = Integer.toString(this.indexer) + " - " + b.getName();
                    this.listedIds.add(b.getId());
                    System.out.println(line);
                });

        this.indexer = 0;
    }

    public void listCustomers(){
        getBranchById(pickBranch()).listCustomers();
    }

    public void listTransactions(){
        Branch branch = getBranchById(pickBranch());
        System.out.println(branch.getCustomerById(branch.pickCustomer()).listTransactions());
    }

    private Branch getBranchById(int id){
        Optional<Branch> branch = branches.stream().filter(b -> {return b.getId() == id;}).findFirst();
        return branch.get();
    }

    public void modifyBranch(){
        int id = pickBranch();
        if(id == 0){
            System.out.println("Cancelled");
            return;
        }
        Branch branch = this.getBranchById(id);
        System.out.println("Enter new name for branch + " + branch.getName() + ": ");
        String newName = scanner.next();
        branch.setName(newName);
        mainMenu();
    }

    public void modifyCustomer(){
        int id = pickBranch();
        if(id == 0){
            System.out.println("Cancelled");
            return;
        }
        Branch branch = this.getBranchById(id);
        branch.modifyCustomer();
        mainMenu();
    }

    public void mainMenu(){
        String menu = "\n\n0 - Exit\n";
        menu += "1 - Add branch\n";
        menu += "2 - Add customer\n";
        menu += "3 - Add transaction\n";
        menu += "4 - Modify branch\n";
        menu += "5 - Modify customer\n";
        menu += "6 - Remove branch\n";
        menu += "7 - Remove customer\n";
        menu += "8 - List branches\n";
        menu += "9 - List customers\n";
        menu += "10 - List transactions\n";
        System.out.println(menu);
        int opt = scanner.nextInt();
        switch(opt){
            case 0:
                return;
            case 1:
                addBranch();
                break;
            case 2:
                addCustomer();
                break;
            case 3:
                addTransaction();
                break;
            case 4:
                modifyBranch();
                break;
            case 5:
                modifyCustomer();
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                listBranches();
                mainMenu();
                break;
            case 9:
                listCustomers();
                mainMenu();
                break;
            case 10:
                listTransactions();
                mainMenu();
                break;
            default:
                mainMenu();
                break;
        }
    };
}
