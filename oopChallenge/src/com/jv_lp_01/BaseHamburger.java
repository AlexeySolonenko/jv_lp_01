package com.jv_lp_01;

public class BaseHamburger extends PricedItem {

    public static final String RIGHTS_HOLDER = "Bills Burgers";



    private AddonBundle extras;
    /* if extras are locked, it is not possible to add new extras */
    private boolean extrasLocked = false;

    private boolean meat;
    private double meatPrice = 2.50;
    private String name;
    private BreadType rollType;


    /**
     * This is a minimum constructor for a base price.
     * Price is to cover costs of cooking a particular kind of burger.
     *
     * @param price
     * @param extrasLocked
     * @param name
     */
    public BaseHamburger(double price, boolean extrasLocked, String name) {
        this(price, extrasLocked,true,1.50,name,new WhiteBunBread());
    }

    public BaseHamburger(double price, boolean extrasLocked, double meatPrice, String name) {
        this(price, extrasLocked,true,meatPrice,name,new WhiteBunBread());
    }

    public BaseHamburger(double price, boolean extrasLocked, double meatPrice, String name, BreadType rollType) {
        this(price, extrasLocked,true,meatPrice,name,rollType);
    }

    public BaseHamburger(double price, boolean extrasLocked, boolean meat, double meatPrice, String name, BreadType rollType) {
        super(price);
        this.extras = new AddonBundle();
        this.extrasLocked = extrasLocked;
        this.meat = meat;
        this.meatPrice = meatPrice;
        this.name = name;
        this.rollType = rollType;
    }

    public void getFinalPrice() {
        /* calculate final price */
        double finalPrice = 0.0;
        String msg = "Burger: " + this.getName() + "\n";

        /* collect extras, if any */
        for(int i = 0; i < this.extras.getAddons().size();i++){
            if(i == 0) msg += "Your extras:" + "\n";
            Addition addon = this.extras.getAddons().get(i);
            finalPrice += addon.getPrice();
            msg += addon.getType() + " x" + addon.getTimesAmount() +
                    "(* " + addon.getPrice() + ") - " + addon.getFulPrice() + "\n";
        }
        finalPrice += this.rollType.getPrice();
        if (this.getMeat()) finalPrice += this.getMeatPrice();
        msg += "Bread/Rool: " + this.getRollType().getType() +" - " + this.getRollType().getPrice() + "\n";
        msg += "Total " + finalPrice;

        System.out.println(msg);


    }

    public AddonBundle getExtras() {
        return extras;
    }

    public void setExtras(AddonBundle extras) {
        if(this.extrasLocked) return;

        this.extras = extras;
    }

    public boolean getMeat() {
        return meat;
    }

    public void setMeat(boolean meat) {
        this.meat = meat;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMeatPrice() {
        return meatPrice;
    }

    public void setMeatPrice(double meatPrice) {
        this.meatPrice = meatPrice;
    }

    public static String getRightsHolder() {
        return RIGHTS_HOLDER;
    }

    public BreadType getRollType() {
        return rollType;
    }

    public void setRollType(BreadType rollType) {
        this.rollType = rollType;
    }
}
