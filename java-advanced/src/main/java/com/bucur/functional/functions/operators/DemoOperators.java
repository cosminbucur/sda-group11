package com.bucur.functional.functions.operators;

import java.util.Arrays;
import java.util.List;

/**
 * Operator interfaces are special cases of a function that receive and
 * return the same value type. The UnaryOperator interface receives a
 * single argument. One of its use cases in the Collections API is to
 * replace all values in a list with some computed values of the same type
 */
public class DemoOperators {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("bob", "josh", "megan");

        names.replaceAll(name -> name.toUpperCase());

        names.forEach(System.out::println);
    }
}
