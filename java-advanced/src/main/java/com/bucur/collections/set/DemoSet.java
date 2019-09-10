package com.bucur.collections.set;

import java.util.HashSet;
import java.util.Set;

public class DemoSet {

    public static void main(String[] args) {
        useHashSet();
    }

    private static void useHashSet() {
        // create - use generics
        Set<String> names = new HashSet<>();

        // add items to list
        names.add("alex");
        names.add("vlad");
        names.add("vlad");
        names.add("greta");

        // read

        // get item from an index
        Object[] namesArray = names.toArray();
        names.isEmpty();

        // get index of an item
//        names.indexOf("greta");

        // update
        // change an item at a given index
//        names.add(0, "cristi");

        // delete - check if exists
//        if (names.contains("vlad")) {
//            names.remove("vlad");
//            names.equals("vlad");
//        }

        // check size
        names.size();

        // iterate
        // for (element type, element name : collection)
        for (String name : names) {
            System.out.println(name);
        }

        // sort
    }

}
