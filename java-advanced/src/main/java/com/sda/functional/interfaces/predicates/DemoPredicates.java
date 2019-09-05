package com.sda.functional.interfaces.predicates;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class DemoPredicates {

    public static void main(String[] args) {
        Predicate<String> nameWithAPredicate = (name) -> name.startsWith("A");

        List<String> names = Arrays.asList("ana", "cristi");
        names.stream()
                .filter(nameWithAPredicate)
                .filter((name) -> name.startsWith("a"));
    }
}
