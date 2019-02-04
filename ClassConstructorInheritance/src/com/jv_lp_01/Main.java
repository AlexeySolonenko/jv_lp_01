package com.jv_lp_01;

public class Main {

    public static void main(String[] args) {
        Car porsche = new Car();
        Car holden = new Car();
        porsche.toString();
        porsche.setModel("Carrera");
        System.out.println("Model is " + porsche.getModel());
        BankAccount ba = new BankAccount();
        System.out.println(ba.deposit(100).getBalance());
        //System.out.println(ba.deposit(100).getBalance());
        System.out.println(ba.withdraw(100));
        System.out.println(ba.deposit(1).getBalance());
        System.out.println(ba.withdraw(100));

        System.out.println();
        BankAccount Kolja = new BankAccount("12345", 1010.10, "Bratan Koljan", "koljan@yandex.ru", "+7986321468");
        BankAccount Vasja = new BankAccount();

        System.out.println(Kolja.toString());
        System.out.println(Vasja.toString());

        VipCustomer vip1 = new VipCustomer();
        VipCustomer vip2 = new VipCustomer("vip2", "ooo@ooo.com");
        VipCustomer vip3 = new VipCustomer("vip3", 100, "vip3@ooo.com");

        Animal animal = new Animal("Animal", 1, 1, 5, 5);
        Dog dog = new Dog("Yorkie", 8, 20, 2, 4, 1, 20, 4, 1, "long silky");

        dog.eat();
        dog.walk();
        dog.run();



    }
}
