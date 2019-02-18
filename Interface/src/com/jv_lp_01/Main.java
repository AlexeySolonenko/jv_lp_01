package com.jv_lp_01;

public class Main {

    public static void main(String[] args) {
        ITelephone phone;
        // DeskPhone phone; also valid, but will fail at re-assignment
        phone = new DeskPhone(123456);
        phone.powerOn();
        phone.callPhone(123456);
        phone.answer();

        phone = new MobilePhone(24565);
        phone.powerOn();
        phone.callPhone(24565);
        phone.answer();


    }
}
