package com.jv_lp_01;

public class Main {

    public static int multiplier = 7;

    public static void main(String[] args) {
        Account ivansAccount = new Account("Tim");
        ivansAccount.deposit(1000);
        ivansAccount.withdraw(500);
        ivansAccount.deposit(-20);
        ivansAccount.withdraw(-200);
        ivansAccount.calcualteBalance();
        // ivansAccount.balance = 5000; // not good

        System.out.println("Balance on acocunt is " + ivansAccount.getBalance());

//        StaticTest firstInstance = new StaticTest("1st Instance");
//        System.out.println(firstInstance.getName() + " is instance number " + firstInstance.getNumInstances());
//        StaticTest secondInstance = new StaticTest("2nd instance");
//        System.out.println(secondInstance.getName() + " is instance number " + secondInstance.getNumInstances());
//
//        StaticTest thirdInstance = new StaticTest("3nd instance");
//        System.out.println(thirdInstance.getName() + " is instance number " + StaticTest.getNuminstances());

        int answer = multiply(6);

        System.out.println("The answser is " + answer);
        System.out.println("Multiplier is " + multiplier);

        SomeClass one= new SomeClass("one");
        SomeClass two = new SomeClass("two");
        SomeClass three = new SomeClass("three");
        System.out.println(one.getInstanceNumber());
        System.out.println(two.getInstanceNumber());
        System.out.println(three.getInstanceNumber());
        System.out.println(Math.PI);
        /* does not work */
        //Matn m = new Math();
        /* keep in mind a final is also can be final */
        int pw = 674312;

        Password password = new ExtendedPassword(pw);
        password.storePassword();
        password.letMeIn(1);
        password.letMeIn(523266);
        password.letMeIn(9889);
        password.letMeIn(0);
        password.letMeIn(-1);
        password.letMeIn(674312);


        System.out.println("Main method called");
        SIBtest test = new SIBtest();
        test.someMethod();;
        System.out.println("Owner is " + SIBtest.owner);
    }


    public static int multiply(int number){
        return number * multiplier;
    }
}
