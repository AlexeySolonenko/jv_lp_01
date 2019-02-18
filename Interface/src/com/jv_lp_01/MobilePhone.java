package com.jv_lp_01;

public class MobilePhone implements ITelephone {

    private int myNumber;
    private boolean isRinging;
    private boolean isOn = false;

    public MobilePhone(int myNumber) {
        this.myNumber = myNumber;
    }

    @Override
    public void powerOn() {
        System.out.println("Mobile phonepowerd up");
        isOn = true;
    }

    @Override
    public void dial(int phoneNumber) {
        if(isOn) {
            System.out.println("Now rining " + phoneNumber + " on deskphone");
        } else {
            System.out.println("Phone is switched off");
        }
    }

    @Override
    public void answer() {
        if(isRinging()){
            System.out.println("Answerint the mobile phone");
            isRinging = false;
        }

    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if(phoneNumber == myNumber && isOn){
            isRinging = true;
            System.out.println("Melody ring ");
        } else {
            isRinging = false;
            System.out.println("Mobile phone is off");
        }
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}
