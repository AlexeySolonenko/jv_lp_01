package com.jv_lp_01;

import java.util.ArrayList;

public class MobilePhone {
    ContactsList contactsList = new ContactsList();

    public MobilePhone() {

    }

    public ContactsList getContactsList() {
        return contactsList;
    }

    public void setContactsList(ContactsList contactsList) {
        this.contactsList = contactsList;
    }
}
