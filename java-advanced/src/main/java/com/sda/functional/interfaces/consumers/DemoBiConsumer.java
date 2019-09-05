package com.sda.functional.interfaces.consumers;

import java.util.HashMap;
import java.util.Map;

public class DemoBiConsumer {

    public static void main(String[] args) {
        Map<String, Integer> ages = new HashMap<>();
        ages.put("ana", 25);
        ages.put("alex", 30);

        // print name - age
        ages.forEach((name, age) ->
                System.out.println("The entry is: " + name + " - " + age));

        // BEST PRACTICE: 1 line per lambda body
        ages.forEach((name, age) -> printEntries(name, age));
    }

    private static void printEntries(String name, Integer age) {
        System.out.println("The name is: " + name);
        System.out.println("The age is: " + age);
        System.out.println("The age is: " + age);
        System.out.println("The age is: " + age);
        System.out.println("The age is: " + age);
        System.out.println("The age is: " + age);
        System.out.println("The age is: " + age);
    }
}
