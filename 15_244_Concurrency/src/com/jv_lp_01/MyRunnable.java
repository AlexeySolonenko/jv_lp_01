package com.jv_lp_01;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(ThreadColor.ANSI_RED + "Hello from my Runnable's implementation of run");
    }
}
