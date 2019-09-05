package com.sda.functional.interfaces.consumers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DemoConsumers {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("alex");
        names.add("ana");


        // for ( type element : collection)
        for (String name : names) {
            System.out.println(name);
        }

        // print names in the list
        Consumer printNamesConsumer = (name) -> {
            System.out.println(name);
        };

        // iterate and print using consumer

        // collection.forEach(consumer)
        names.forEach(printNamesConsumer);

        // version 2
        names.forEach((name) -> {
            System.out.println(name);
        });

        // version 3
        names.forEach((name) -> System.out.println(name));

        // version 4

        // collection.forEach( element -> command (void) )
        names.forEach(name -> System.out.println(name));
    }
}
