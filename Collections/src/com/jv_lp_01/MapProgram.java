package com.jv_lp_01;

import java.util.HashMap;

public class MapProgram {
    public static void main(String[] args) {
        java.util.Map<String, String> languages = new HashMap<>();

        if(languages.containsKey("Java")){
            System.out.println("Java is already in the map");
        } else {
            languages.put("Java","added successfully");
        }
        languages.put("Java", "a complied high level, object oriented, platform independant language");
        languages.put("Python","an interpreted, object-oriented, high-level programming language with dynamic semantcis");
        languages.put("Algol","an alogorithmic language");
        languages.put("BASIC", "Beginners all purpsose symbolic instrucitons code");
        languages.put("Lisp", "therein lies madness");

        if(languages.containsKey("Java")){
            System.out.println("Java is already in the map");
         } else {
            languages.put("Java","this course is about Java");
        }

        System.out.println(languages.get("Java"));
        languages.put("Java","this cours is about Java");
        System.out.println("================================");
        //languages.remove("Lisp");
        /* will also check for a value */
        if(languages.remove("Algol","a family of algorithmic languages")){
            System.out.println("Algol removed");
        } else {
            System.out.println("Algol not removed, key/value pair not found");
        }

        if(languages.replace("List","this will not work","a functional programming langage with imperative features")){
            System.out.println("Lisp replaced");
        } else {
            System.out.println("Lisp was not replaced");
        }
        System.out.println(languages.replace("Scala","thiw will not be replaced"));

        for(String key: languages.keySet()){
            System.out.println(key + " : " + languages.get(key));
        }



    }
}
