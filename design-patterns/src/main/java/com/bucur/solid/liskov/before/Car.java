package com.bucur.solid.liskov.before;

public class Car extends TransportationDevice {

    @Override
    public void startEngine() {
        System.out.println("start the car");
    }
}
