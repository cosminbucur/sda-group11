package com.bucur.patterns.creational.singleton.enum_singleton;

public enum EnumSingleton {

    INSTANCE("initial value");

    private String value;

    EnumSingleton(String value) {
        this.value = value;
    }

    public EnumSingleton getInstance() {
        return INSTANCE;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
