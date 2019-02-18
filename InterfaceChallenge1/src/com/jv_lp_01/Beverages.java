package com.jv_lp_01;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Beverages implements ISaveable2 {
    private List<String> beberages = new LinkedList<String>();

    @Override
    public List read2() {
        return beberages;
    }

    @Override
    public void write2(List list) {
        beberages.addAll(list);
    }

    @Override
    public String toString(){
        return beberages.stream().collect(Collectors.joining(","));
    }
}
