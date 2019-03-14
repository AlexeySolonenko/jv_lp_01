package com.jv_lp_01;

public class Main {

    public static void main(String[] args) {
        System.out.println(ThreadColor.ANSI_PURPLE + "Hello from the main thread ");
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ");
        /* don't run, runs from main, not from another thread */
        //anotherThread.run();

        anotherThread.start();

        new Thread() {
            public void run() {
                System.out.println(ThreadColor.ANSI_GREEN + "Hello from the anonymous class thread");
            }
        }.start();

        //Thread myRunnableThread = new Thread(new MyRunnable());
        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ThreadColor.ANSI_RED + " Hello from an overriden anonymous implementation of my runnable");
                try{
                    //anotherThread.join(2000);
                    anotherThread.join();
                    System.out.println(ThreadColor.ANSI_RED + "AnotherThread terminated, or timed-out, so I'm running again");
                } catch (InterruptedException e){
                    System.out.println(ThreadColor.ANSI_RED + " I could not wait after all. I was interrupted");
                }
            }
        });



        /* runnable is used more often */


        myRunnableThread.start();

        anotherThread.interrupt();

        System.out.println(ThreadColor.ANSI_PURPLE + "Hello again from the main thread");

        //anotherThread.start();

    }
}
