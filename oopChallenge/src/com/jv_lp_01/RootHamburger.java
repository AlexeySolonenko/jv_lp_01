package com.jv_lp_01;

public class RootHamburger extends PricedItem {

    public static final String RIGHTS_HOLDER = "Bills Burgers";

    /**
     * @var Holds extras. Descendant classes may disable access to this bundle.
     *
     * Actually, only after a while I realized, that there actually might be 2 sets of bundles:
     * 1) One for constructor setup
     * 2) One for explicit prevention of access
     */
    private ExtrasBundle extras;
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
    public RootHamburger(double price, boolean extrasLocked, String name) {
        this(price, extrasLocked,true,1.50,name,new WhiteBunBread());
    }

    public RootHamburger(double price, boolean extrasLocked, double meatPrice, String name) {
        this(price, extrasLocked,true,meatPrice,name,new WhiteBunBread());
    }

    public RootHamburger(double price, boolean extrasLocked, double meatPrice, String name, BreadType rollType) {
        this(price, extrasLocked,true,meatPrice,name,rollType);
    }

    public RootHamburger(double price, boolean extrasLocked, boolean meat, double meatPrice, String name, BreadType rollType) {
        super(price);
        this.extras = new ExtrasBundle();
        this.extrasLocked = extrasLocked;
        this.meat = meat;
        this.meatPrice = meatPrice;
        this.name = name;
        this.rollType = rollType;
    }

    public void getFinalPrice() {
        /* calculate final price */
        double finalPrice = 0.0;
        String msg = "\n\n*****\n\nPlease, find your bill" + "\n";
        msg += "Burger: " + this.getName() + "\n";
        msg += "Base price: " + this.getPrice() + "\n";
        finalPrice += this.getPrice();
        msg += "Bread/Roll: " + this.getRollType().getType() +" - " + this.getRollType().getPrice() + "\n";
        finalPrice += this.rollType.getPrice();
        if (this.getMeat()) {
            msg += "Meat: " + this.getMeatPrice() + "\n";
            finalPrice += this.getMeatPrice();
        }

        /* collect extras, if any */
        for(int i = 0; i < this.extras.getExtras().size(); i++){
            if(i == 0) msg += "Your extras:" + "\n";
            Extra addon = this.extras.getExtras().get(i);
            finalPrice += addon.getFulPrice();
            msg += addon.getType() + " x" + addon.getTimesAmount() +
                    "(* " + addon.getPrice() + ") - " + addon.getFulPrice() + "\n";
        }



        msg += "Total " + finalPrice+ "\n\n";
        msg += "Thank you for buying from " + RootHamburger.RIGHTS_HOLDER + "\n\n";
        msg += "Enjoy your meal and have a nice day!\n\n*****\n\n";

        System.out.println(msg);


    }

    public ExtrasBundle getExtrasBundle() {
        if(this.extrasLocked) return new ExtrasBundle();
        if(this.extras.getExtras().size() > this.extras.getMaxExtras()) return null;

        return extras;
    }

    public void setExtrasBundle(ExtrasBundle extras) {
        if(this.extrasLocked) return;
        if(this.extras.getExtras().size() > this.extras.getMaxExtras()) return;

        this.extras = extras;
    }

    public boolean getExtrasLocked() {
        return extrasLocked;
    }

    public void setExtrasLocked(boolean extrasLocked) {
        this.extrasLocked = extrasLocked;
    }

    public boolean isMeat() {
        return meat;
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
