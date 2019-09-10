package com.bucur.functional.functions.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;

public class DemoBinaryOperator {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("X", "A");
        map.put("Y", "B");
        map.put("Z", "C");
        BinaryOperator<String> binaryOpt = (s1, s2) -> s1 + "-" + s2;
        useBinaryOperator(binaryOpt, map).forEach(x -> System.out.println(x));
    }

    private static List<String> useBinaryOperator(BinaryOperator<String> binaryOpt, Map<String, String> map) {
        List<String> biList = new ArrayList<>();
        map.forEach((s1, s2) -> biList.add(binaryOpt.apply(s1, s2)));
        return biList;
    }
}
