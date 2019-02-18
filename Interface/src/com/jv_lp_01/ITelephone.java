package com.jv_lp_01;

public interface ITelephone {

    public void powerOn();

    public void dial(int phoneNumber);

    public void answer();

    public boolean callPhone(int phoneNumber);

    public boolean isRinging();
}
