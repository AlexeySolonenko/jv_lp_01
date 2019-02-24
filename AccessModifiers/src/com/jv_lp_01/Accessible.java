package com.jv_lp_01;
/* package private - accessible only to members of jv_lp_01 package */
/* all method in interface are public */
interface Accessible {
    /* public static final - a class constant  */
    int SOME_CONSTANT = 100;
    /* to all */
    public void methodA();
    /* only public  */
    void methodB();
    /* only public */
    boolean methodC();
}
