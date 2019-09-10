package com.bucur.patterns.creational.singleton.simple_singleton;

public class DemoSingleton {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance("HELLO");
        Singleton anotherSingleton = Singleton.getInstance("HELLO2");

        System.out.println("singleton.value = " + singleton.value);
        System.out.println("anotherSingleton.value = " + anotherSingleton.value);
    }
}
