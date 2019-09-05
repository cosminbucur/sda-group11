package com.sda.functional.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DemoMap {

    public static void main(String[] args) {
        // foods which helps in weight loss
        List<String> loseWeight = new ArrayList<>();
        loseWeight.add("avocados");
        loseWeight.add("beans");
        loseWeight.add("salad");
        loseWeight.add("oats");
        loseWeight.add("broccoli");

        System.out.println("list of String : " + loseWeight);

        // let's use map() method to convert list of weight
        // lose food, which are String to list of ints
        // which are length of each food String

        List listOfInts = loseWeight.stream()
                .map(s -> s.length())
                .collect(Collectors.toList());

        System.out.println("list of ints generate by map(): " + listOfInts);
    }
}
