package com.sda.annotation;

import java.util.ArrayList;
import java.util.List;

public class DemoAnnotation {

    public static void main(String[] args) {
        List names = new ArrayList();

        addToList(names, "alex");

        List newList = updateList(names, "ana");
    }

    // var 1 create object inside of method
    private static void addToList() {
        List list = new ArrayList();
        String element = "alex";
        list.add(element);
    }

    // var 2 pass object as parameter
    @SuppressWarnings("unchecked")
    private static void addToList(List list, String element) {
        list.add(element);
    }

    // var 3 pass object as parameter and return the modified object
    private static List updateList(List list, String element) {
        list.add(element);
        return list;
    }
}
