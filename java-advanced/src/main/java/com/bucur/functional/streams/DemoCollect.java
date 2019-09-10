package com.bucur.functional.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DemoCollect {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("one");
        names.add("two");
        names.add("three");

        List<String> uppercaseNames = names.stream()
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(uppercaseNames);
    }
}
