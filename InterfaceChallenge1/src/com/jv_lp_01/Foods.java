package com.jv_lp_01;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Foods implements ISaveable2 {
    private List<String> foods = new LinkedList<String>();
    @Override
    public List read2() {
        return foods;
    }

    @Override
    public void write2(List list) {
        foods.addAll(list);
    }

    @Override
    public String toString(){
        return foods.stream().collect(Collectors.joining(","));
    }
}
