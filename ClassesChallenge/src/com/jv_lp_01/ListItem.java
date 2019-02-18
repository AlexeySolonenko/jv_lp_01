package com.jv_lp_01;

import java.util.ListIterator;

public abstract class ListItem {
    protected ListItem next = null;
    protected ListItem previous = null;
    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    abstract ListItem next();
    abstract ListItem setNext(ListItem item);
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem item);

    abstract int compareTo(ListItem item);

//    public ListItem getNext() {
//        return next;
//    }



//    public ListItem getPrevious() {
//        return previous;
//    }


    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
