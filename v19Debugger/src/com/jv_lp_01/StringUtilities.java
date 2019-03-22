package com.jv_lp_01;

public class StringUtilities {
    private StringBuilder sBuilder = new StringBuilder();
    private int charsAdded = 0;

    public void addChar(StringBuilder sBuilder, char c){
        //this.sBuilder.append(c);
        sBuilder.append(c);
        charsAdded++;
    }

    public String uppserAndPrefix(String str){
        String upper = str.toUpperCase();
        return "Prefix_"+upper;
    }

    public String addSuffix(String str){
        return str+"_suffix";

    }
}
