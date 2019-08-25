package com.sda.collections.list;

import java.util.ArrayList;
import java.util.List;

public class DemoList2 {

    public static void main(String[] args) {
        useArrayList();
    }

    private static void useArrayList() {
        // create - use generics
        List<String> names = new ArrayList<>();

        // add items to list
        names.add("alex");
        names.add("vlad");
        names.add("greta");

        // read

        // get item from an index
        names.get(1);

        // get index of an item
        names.indexOf("greta");

        // update

        // change an item at a given index
        names.add(0, "cristi");

        // delete - check if exists
        if (names.contains("vlad")) {
            names.remove("vlad");
            names.equals("vlad");
        }

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
