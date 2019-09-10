package com.bucur.oop.abstraction;

public class Car extends Vehicle {

    public Car(int maxSpeed) {
        super(maxSpeed);
    }

    @Override
    public void move() {
        System.out.println("car moving...");
    }
}
