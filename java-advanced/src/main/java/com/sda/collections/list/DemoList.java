package com.sda.collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DemoList {

    public static void main(String[] args) {
        // CREATE

        // add items
        List<String> visitedCountries = new ArrayList<>();
        visitedCountries.add("england");
        visitedCountries.add("spain");
        visitedCountries.add("korea");

        List<Integer> myIntegers = new LinkedList<>();

        // READ
        Iterator<String> iterator = visitedCountries.iterator();

        while (iterator.hasNext()) {
            String nextCountry = iterator.next();
            System.out.println(nextCountry);
        }

        String spain = visitedCountries.get(1);
        System.out.println(spain);

        int indexOfEngland = visitedCountries.indexOf("england");

        // UPDATE

        visitedCountries.add(0, "france");

        // DELETE

        String countryToDelete = "korea";
        if (visitedCountries.contains(countryToDelete)) {
            visitedCountries.remove(countryToDelete);
        } else {
            throw new RuntimeException(countryToDelete + " is not in the list");
        }

        System.out.println("number of countries: " + visitedCountries.size());

        printListElements(visitedCountries);
    }

    private static void printListElements(List<String> anyList) {
        for (String element : anyList) {
            System.out.println(element);
        }
    }
}
