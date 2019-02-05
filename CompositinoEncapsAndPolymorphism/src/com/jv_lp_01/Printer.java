package com.jv_lp_01;

public class Printer {
    private int tonerLevel = 25;
    private int numberOfPagesPrinted = 0;
    private boolean isDubplex;

    public Printer(int tonerLevel, boolean isDubplex) {
        if (tonerLevel > -1 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;
        }
        this.isDubplex = isDubplex;
    }

    public void refillToner() {
        this.tonerLevel = 100;
    }

    public void printPage(){
        this.printPage(1,false);
    }
    public void printPage(int pages){
        this.printPage(pages,false);
    }
    public void printPage(boolean isDubplex) {
        this.printPage(1,isDubplex);
    }

    public void printPage(int n, boolean duplex) {
        int tonerUsage = duplex ? 4 : 2;
        if (getTonerLevel() <= 0 || getTonerLevel() < n * tonerUsage) {
            System.out.println("Not enough toner to print.");
        } else {
            this.setTonerLevel(getTonerLevel() - tonerUsage * n);
            this.setNumberOfPagesPrinted(getNumberOfPagesPrinted() + n);
            System.out.println("Printed " + n + " pages, and used " + n * tonerUsage + " units of toner");
        }
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public void setTonerLevel(int tonerLevel) {
        this.tonerLevel = tonerLevel;
    }

    public int getNumberOfPagesPrinted() {
        return numberOfPagesPrinted;
    }

    public void setNumberOfPagesPrinted(int numberOfPagesPrinted) {
        this.numberOfPagesPrinted = numberOfPagesPrinted;
    }

    public boolean isDubplex() {
        return isDubplex;
    }

    public void setDubplex(boolean dubplex) {
        isDubplex = dubplex;
    }

}
