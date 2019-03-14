package com.jv_lp_01;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Challenge7 {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("12345-678", 500.00);
        BankAccount account2 = new BankAccount("98765-432", 1000.00);

        new Thread(new Transfer(account1, account2, 10.00), "Transfer1").start();
        new Thread(new Transfer(account2, account1, 55.88), "Transfer2").start();
    }
}

class BankAccount {
    private double balance;
    private String accountNumber;
    private Lock lock = new ReentrantLock();

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public boolean withdraw(double amount) {
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                //try {
                // Simulate database access
                Thread.sleep(100);
//            } catch (InterruptedException e) {
//            }
                balance -= amount;
                System.out.printf("%s: Withdrew %f\n", Thread.currentThread().getName(), amount);
                lock.unlock();
                return true;
            } else {
                System.out.println("System is busy, could not withdraw");
            }
        } catch (InterruptedException e) {
            /* do nothing */
        }
        return false;
    }

    public boolean deposit(double amount) {
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                //try {
                // Simulate database access
                Thread.sleep(100);
//                } catch (InterruptedException e) {
//                }
                balance += amount;
                System.out.printf("%s: Deposited %f\n", Thread.currentThread().getName(), amount);
                lock.unlock();
                return true;
            } else {
                System.out.println("System is busy, could not deposit");
            }
        } catch (InterruptedException e) {
            /* do nothing */
        }
        return false;
    }

    public boolean transfer(BankAccount destinationAccount, double amount) {
        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if(destinationAccount.lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                    if (withdraw(amount)) {
                        if (destinationAccount.deposit(amount)) {
                            destinationAccount.lock.unlock();
                            lock.unlock();
                            return true;
                        } else {
                            // The deposit failed. Refund the money back into the account.
                            System.out.printf("%s: Destination account busy. Refunding money\n",
                                    Thread.currentThread().getName());
                            deposit(amount);
                        }
                    }
                    destinationAccount.lock.unlock();
                } else {
                    System.out.println("Could not access account to");
                    lock.unlock();
                }
            } else {
                System.out.println("Could not access account from ");
                lock.unlock();
            }
        }
        catch(InterruptedException e){
            /* do nothing*/
            }

        return false;
    }
}

class Transfer implements Runnable {
    private BankAccount sourceAccount, destinationAccount;
    private double amount;

    Transfer(BankAccount sourceAccount, BankAccount destinationAccount, double amount) {
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
    }

    public void run() {
        while (!sourceAccount.transfer(destinationAccount, amount))
            continue;
        System.out.printf("%s completed\n", Thread.currentThread().getName());
    }

}
