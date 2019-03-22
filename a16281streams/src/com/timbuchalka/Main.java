package com.timbuchalka;

import javax.xml.stream.events.Characters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "O71");

        List<String> gNumbers = new ArrayList<>();

//        someBingoNumbers.forEach(number -> {
//            if(number.toUpperCase().startsWith("G")) {
//                gNumbers.add(number);
////                System.out.println(number);
//            }
//        });
//
//        gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));
//        gNumbers.forEach((String s) -> System.out.println(s));
        /* all the methods are not from other classes, but from stream! forEach from stream, not from ITerator */
        someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);

        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "Q71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);
        //System.out.println(concatStream.count());
        //System.out.println(concatStream.distinct().count());
        System.out.println(concatStream.distinct().peek(System.out::println).count());


        Employee john = new Employee("John Doe", 30);
        Employee jane = new Employee("Jane Deer", 25);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);

        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments.stream().flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        List<String> sortedGNumber = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(Collectors.toList());

        sortedGNumber.forEach(System.out::println);

        List<String> sortedGNumber2 = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        sortedGNumber.forEach(System.out::println);

        Map<Integer, List<Employee>> groupByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);
        /* not executed without terminal operations */
        Stream.of("ABC", "AC", "BAA", "CCCC", "ST", "XY")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() == 3;
                });
        /* now good */
        Stream.of("ABC", "AC", "BAA", "CCCC", "ST", "XY")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() == 3;
                }).count();

        Consumer<String> splitter = (s) -> {
            String myString = "Let's split this up into an array ";
            String[] parts = myString.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };

        Runnable runnable1 = () -> {
            String myString = "Let's split this up into an array ";
            String[] parts = myString.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };

        Function<String, String> challenge2 = (s) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(challenge2.apply("123456789"));
        String src = "12345678910111213141516";
        System.out.println(everySecondCharacter(challenge2, src));
        Supplier<String> chall6 = () -> "I love Java!";
        String result = chall6.get();
        System.out.println(result);

        List<String> topNames2015 = Arrays.asList(
                "amelia",
                "Olivia",
                "Emily",
                "isla",
                "ava",
                "oliver",
                "jack",
                "Charlie",
                "harry",
                "jacob"
        );
        topNames2015.stream().map((s) -> Character.toUpperCase(s.charAt(0)) + s.substring(1)).sorted().forEach(System.out::println);

        topNames2015.stream().
                map((s) -> Character.toUpperCase(s.charAt(0)) + s.substring(1))
                .sorted(String::compareTo)
                .forEach(System.out::println);

        System.out.println(topNames2015.stream().
                filter((s) -> s.substring(0,1).equalsIgnoreCase("A"))
                .count());


        topNames2015.stream().
                map((s) -> Character.toUpperCase(s.charAt(0)) + s.substring(1))
                .peek(System.out::println)
                .sorted(String::compareTo)
                .forEach((s) -> {});


    }

    public static String everySecondCharacter(Function<String, String> func, String source) {
        return func.apply(source);
    }
}
