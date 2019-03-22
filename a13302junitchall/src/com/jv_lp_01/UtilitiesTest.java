package com.jv_lp_01;

import java.util.Arrays;

import static org.junit.Assert.*;


public class UtilitiesTest {

    private Utilities utils;

//    @org.junit.Before
//    public void onlyOnce() {
//        utils = new Utilities();
//    }


    @org.junit.Before
    public void setUp() throws Exception {
        utils = new Utilities();
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void everyNthChar() {
        //fail("Every nth char");
        char[] expected = {'e','l'};
        char[] input = {'h','e','l','l','o'};
        assertArrayEquals(expected,utils.everyNthChar(input,2));
        assertArrayEquals(input,utils.everyNthChar(input,6));
        // remember new char[]{} !!!!
    }

    @org.junit.Test
    public void removePairs() {
        assertEquals("ABCDEF", utils.removePairs("AABCDEFF"));
        assertEquals("ABCABDEF", utils.removePairs("ABCCABDEEF"));
        assertEquals("", utils.removePairs(""));
        assertEquals("a", utils.removePairs("a"));
        assertEquals(null, utils.removePairs(null));

    }

    @org.junit.Test(expected = ArithmeticException.class)
    public void converter() {
        assertEquals(300,utils.converter(10,5));
        assertEquals(300,utils.converter(10,0));
    }

    @org.junit.Test
    public void nullIfOddLength()  {
        assertEquals(null,utils.nullIfOddLength("adf"));
        assertEquals("ad",utils.nullIfOddLength("ad"));

    }
}