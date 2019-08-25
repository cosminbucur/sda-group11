package com.sda.collections.map;

import java.util.HashMap;
import java.util.Map;

public class DemoMapOfMap {

    public static void main(String[] args) {
        Map<String, String> mikeDetails = new HashMap<>();
        mikeDetails.put("cnp", "123");
        mikeDetails.put("birthday", "15.05.1987");

        Map<String, Map<String, String>> people = new HashMap<>();
        people.put("mike", mikeDetails);
    }
}
