package com.sda.collections.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DemoMap {

    public static void main(String[] args) {
        Map<String, Integer> addresses = new HashMap<>();
        addresses.put("Poland", 3);
        addresses.put("Germany", 5);
        Collection<Integer> intValues = addresses.values();

        Map<String, String> countries = new HashMap<>();
        countries.put("Poland", "Warsaw");
        countries.put("Germany", "Berlin");

        System.out.println(countries.get("Poland"));

        countries.keySet();
        // get a collection of the map values

        Collection<String> mapValues = countries.values();
        for (String value : mapValues) {
            System.out.println(value);
        }

        // iterate using entry
        // interface.class
        /*
         * interface Map {
         *
         *   // nested interface / class
         *   interface Entry {
         *   }
         * }
         * */

        // entry from the set of entries (no duplicates)
        printMap(countries);
    }

    private static void printMap(Map<String, String> countries) {
        for (Map.Entry<String, String> entry : countries.entrySet()) {
            // entry = key + value
            String country = entry.getKey();
            String capital = entry.getValue();
            System.out.printf("%s : %s \n ", country, capital);
        }
    }
}
