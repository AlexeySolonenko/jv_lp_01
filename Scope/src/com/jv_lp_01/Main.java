package com.jv_lp_01;

public class Main {

    public static void main(String[] args) {
        String varFour = "this is private to main()";
        ScopeCheck scopeInstance = new ScopeCheck();
        scopeInstance.useInner();

        ScopeCheck.InnerClass innerClass2 = scopeInstance.new InnerClass();
        System.out.println("varThree is not accessible here " + innerClass2.varThree);

        System.out.println("ScopeInstance varOne is " + scopeInstance.getVarOne());
        System.out.println(varFour);
        scopeInstance.timesTwo();
        System.out.println("**************************");
        ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
        innerClass.timesTwo();
    }
}
