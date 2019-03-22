package com.jv_lp_01;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class UtilitiesRemovePairsTest {
    private String expected;
    private String input;
    private Utilities utils;

    public UtilitiesRemovePairsTest(String input,String expected) {
        this.expected = expected;
        this.input = input;
        this.utils = new Utilities();
    }

    @Parameterized.Parameters
    public static Collection<String[]> testConditions(){
        return Arrays.asList(new String[][]{
                {"ABCDEFF","ABCDEF"},
                {"AB88EFFG","AB8EFG"},
                {"112233445566","123456"},
                {"ZYZQQB","ZYZQB"},
                {"A","A"}
        });
    }

    @org.junit.Test
    public void removePairs(){
        System.out.println("Testing input " + input + ". Expected: " + expected);
        assertEquals(expected,utils.removePairs(input));
    }



}
