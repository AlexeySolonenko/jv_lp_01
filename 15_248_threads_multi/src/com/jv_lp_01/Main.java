package com.jv_lp_01;


import static com.jv_lp_01.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
        /* when can synchronize both, methods and statements. Syncs only inside a single method or var  */
        Countdown countdown = new Countdown();

        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread1");
        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName("Thread2");

        /* intrinsic lock / monitor concepts */
        /* primitives do not have intrinsice lock */
        t1.start();
        t2.start();

    }


}

class Countdown {

    private int i;

    public /* synchronized */ void doCountdwown() {
        String color;

        switch (Thread.currentThread().getName()) {
            case "Thread1":
                color = ANSI_CYAN;
                break;
            case "Thread2":
                color = ANSI_PURPLE;
                break;
            default:
                color = ANSI_GREEN;
        }
        /* local var is created in a thread stack - no sense to sync on it */
        /* we need to sync on shared objects, on objects in a heap, only exception is String ,
        but see a particular ex, String is an objeect, after all  */
        /* we tried to sync on color, but it did not work */
        /* also static objects and metohds can be synced on */

        /*  sync as little as possible - its resource consumptive  */
        synchronized (this){
            for (i = 10; i > 0; i--) {
                System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
            }
        };

    }
}

class CountdownThread extends Thread {
    private Countdown threadCountdown;

    public CountdownThread(Countdown countdown) {
        threadCountdown = countdown;
    }

    public void run() {
        threadCountdown.doCountdwown();
    }
}
