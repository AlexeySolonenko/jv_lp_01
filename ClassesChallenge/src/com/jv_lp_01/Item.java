package com.jv_lp_01;

public class Item extends ListItem {



    public Item(Object value) {
        super(value);
    }

    @Override
    public ListItem next(){
//        Integer val  = value;
//        next = getNext().getNext();
//        previous = getPrevious().getNext();
//        value = getNext().getValue();

        return this.next;
    }
    @Override
    public ListItem previous(){
//        Object val = value;
//        next = getPrevious().getPrevious();
//        previous = getNext().getPrevious();
//        value = getPrevious().getValue();
        return this.previous;
    }

    @Override
    ListItem setNext(ListItem item) {
        this.next = item;
        return this.next;
    }

    @Override
    ListItem setPrevious(ListItem item) {
        this.previous = item;
        return this.previous;
    }

//    @Override
//    public Integer getValue() {
//        return this.getValue();
//    }

    @Override
    public int compareTo(ListItem item) {
        if(item != null){
            return ((String)super.getValue()).compareTo((String)item.getValue());
        } else {
            return -1;
        }
    }
//
//    public void setValue(Integer value) {
//        this.setValue(value);
//    }
}
