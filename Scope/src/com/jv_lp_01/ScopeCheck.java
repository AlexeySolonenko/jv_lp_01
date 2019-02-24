package com.jv_lp_01;

/**
 *
 */
public class ScopeCheck {
    public int publicVar;
    private int varOne = 1;

    public ScopeCheck(){
        System.out.println("ScopeCheck created, publicVar = " + publicVar + ": varOne = " + varOne);

    }

    public int getVarOne() {
        return varOne;
    }

    public void timesTwo(){
        int varTwo = 2;
        for(int i = 0; i < 10; i ++){
            System.out.println(i + " time two is " + i * varTwo);
        }
        /* not availalbe in thsi scope*/
        //System.out.println("Value of i is now " + i);
    }

    public void useInner(){
        InnerClass innerClass = new InnerClass();
        System.out.println("varThree from outer class: " + innerClass.varThree);
    }

    public class InnerClass{
        public int varThree = 3;

        public InnerClass() {
            System.out.println("Inner class clreated, varOne is " + varOne + " and varThree is " + varThree);
        }

        public void timesTwo(){
            System.out.println("varOne is still available here: " + varOne);
            ScopeCheck.this.timesTwo();
            //int privateVar = 2;
            for(int i = 0; i < 10; i ++){
                //System.out.println(i + " time two is " + i * privateVar);
                /* does not work if InnerClass.this is not defined */
                System.out.println(i + " time two is " + i * varThree);
                //System.out.println(i + " time two is " + i * ScopeCheck.this.varOne);

            }
        }
    }
}
