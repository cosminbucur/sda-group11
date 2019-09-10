package com.bucur.patterns.creational.singleton.simple_singleton;

// can not extend
public final class Singleton {

    // this is a reference to the singleton instance
    private static Singleton instance;

    public String value;

    // prevent initialization
    private Singleton(String value) {
        this.value = value;
    }

    // get instance of the singleton
    public static Singleton getInstance(String value) {
        if (instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }
}
