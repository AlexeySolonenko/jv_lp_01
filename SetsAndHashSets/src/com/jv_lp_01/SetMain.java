package com.jv_lp_01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMain {

    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<Integer>();
        Set<Integer> cubes = new HashSet<Integer>();
        for(int i =1; i <= 100; i++){
            squares.add(i * i);
            cubes.add(i * i * i);
        }
        System.out.println("There are " + squares.size() + " squares and " + cubes.size() + " cubes");
        Set<Integer> union = new HashSet<Integer>(squares);
        union.addAll(cubes);
        System.out.println("Union contains " + union.size() + " elements");

        Set<Integer> intersection = new HashSet<Integer>(squares);
        intersection.retainAll(cubes);
        System.out.println("Intersection contains " + intersection.size() + " elements");
        for(int i : intersection){
            System.out.println(i + " is the square of " + Math.sqrt(i) + " and the cuve of " + Math.cbrt(i));
        }

        Set<String> words = new HashSet<String>();
        String sentence = "one day in the year of a fox";
        String[]  arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));
        for(String s: words){
            System.out.println(s);
        }
        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();
        String[] natureWords = "All nature is but arg unknown to thee".split(" ");
        nature.addAll(Arrays.asList(natureWords));
        String[] divineWords = "To err is human to forgive divine".split(" ");
        divine.addAll(Arrays.asList(divineWords));

        System.out.println("natujre - divine: " );
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);
        System.out.println("divine - nature ");
        Set<String> diff2 = new HashSet<>(divine);
        printSet(diff2);

        Set<String> unionTest = new HashSet<String>(nature);
        unionTest.addAll(divine);
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine);
        printSet(unionTest);
        printSet(intersectionTest);

        System.out.println("Symmetric difference");
        unionTest.removeAll(intersectionTest);
        printSet(unionTest);

        /* used to test if one set is a subset of another */
        if(nature.containsAll(divine)){
            System.out.println("divine is a subset of nature");

        }
        if(nature.containsAll(intersectionTest)){
            System.out.println("Intersection is a subset of nature");
        }
        if(divine.containsAll(intersectionTest)){
            System.out.println("Intersection is a subset of divine");
        }
    }

    private static void printSet(Set<String> set){
        System.out.println("\t");
        for(String s : set){
            System.out.print(s + " ");

        }
        System.out.println();
    }
}
