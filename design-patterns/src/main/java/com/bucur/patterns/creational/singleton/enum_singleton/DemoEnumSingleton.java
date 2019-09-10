package com.bucur.patterns.creational.singleton.enum_singleton;

public class DemoEnumSingleton {

    public static void main(String[] args) {
        EnumSingleton singleton = EnumSingleton.INSTANCE.getInstance();

        System.out.println("singleton value = " + singleton.getValue());

        EnumSingleton anotherSingleton = EnumSingleton.INSTANCE.getInstance();
        anotherSingleton.setValue("HELLO 2");

        System.out.println("singleton 1 value = " + singleton.getValue());
        System.out.println("singleton 2 value = " + anotherSingleton.getValue());
    }
}
