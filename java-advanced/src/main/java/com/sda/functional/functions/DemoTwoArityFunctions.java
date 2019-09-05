package com.sda.functional.functions;

import java.util.HashMap;
import java.util.Map;

/**
 * BiFunction has both arguments and a return type generified, while ToDoubleBiFunction and others
 * allow you to return a primitive value
 */
public class DemoTwoArityFunctions {

    public static void main(String[] args) {
        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("John", 40000);
        salaries.put("Freddy", 30000);
        salaries.put("Samuel", 50000);

        // increase all except freddy's salary
        salaries.replaceAll((name, oldValue) ->
                name.equals("Freddy") ? oldValue : oldValue + 10000);

        salaries.forEach((name, salary) -> System.out.println(name + " - " + salary));
    }
}