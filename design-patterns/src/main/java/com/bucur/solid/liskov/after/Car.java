package com.bucur.solid.liskov.after;

public class Car extends DeviceWithEngine {

    @Override
    public void startEngine() {
        System.out.println("car starts engine");
    }
}
