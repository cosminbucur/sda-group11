package com.bucur.functional.lambda;

import java.util.Arrays;
import java.util.List;

public class DemoLambda {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("one", "two", "three");
        names.forEach(name -> System.out.println(name.toUpperCase()));
    }
}
