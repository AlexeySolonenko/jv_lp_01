package com.jv_lp_01;

import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount account;
    private static int count;

    @org.junit.BeforeClass
    public static void beforeClass(){
        System.out.println("This executes before any test cases. Count = " + count++);
    }

    /* reruns before very test method */
    @org.junit.Before
    public void setup(){
        this.account = new BankAccount("Ivan","Rim",1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }



    @org.junit.Test
    public void deposit() {
        //BankAccount account = new BankAccount("Ivan","Rim",1000.00, BankAccount.CHECKING);
        double balance = account.deposit(200.00,true);
        assertEquals(1200.00,balance,0);
        assertEquals(1200.00,account.getBalance(),0);
    }

    @org.junit.Test
    public void withdraw_branch() throws Exception {
        double balance = account.withdraw(600.00,true);
        assertEquals(400.00,balance,0);
    }


    @org.junit.Test(expected = IllegalStateException.class)
    public void withdraw_atm() throws Exception {
        double balance = account.withdraw(600.00,false);
        assertEquals(400.00,balance,0);
    }

    @org.junit.Test(expected = IllegalStateException.class)
    public void withdraw_atm_exception() throws Exception {
        account.withdraw(600.00,false);
        //assertEquals(400.00,balance,0);
    }

    @org.junit.Test
    public void withdraw_atm_exception_old_way() throws Exception {
        try {
            account.withdraw(600.00, false);
            fail("Shlould have thrown an illegal argument exception");
        } catch( IllegalStateException e){
            System.out.println("Test passed with throwing  and exceptoin");
        }
        //assertEquals(400.00,balance,0);
    }

    @org.junit.Test
    public void getBalance_deposit() {
        //B//ankAccount account = new BankAccount("Ivan","Rim",1000.00, BankAccount.CHECKING);
        account.deposit(200.00,true);
        assertEquals(1200.00,account.getBalance(),0);
    }

    @org.junit.Test
    public void getBalance_withdraw() {
        //BankAccount account = new BankAccount("Ivan","Rim",1000.00, BankAccount.CHECKING);
        account.withdraw(200.00,true);
        assertEquals(800.00,account.getBalance(),0);
    }

    @org.junit.Test
    public void isChecking_true(){
        //BankAccount account = new BankAccount("Ivan","Rim",1000.00, BankAccount.CHECKING);
        assertTrue("The account is not checking account",account.isChecking());
    }

    @org.junit.AfterClass
    public static void AfterClass(){
        System.out.println("This executes after any test cases. Count = " + count++);
    }

    @org.junit.After
    public void teardown(){
        System.out.println("Count = " + count++);
    }
}

