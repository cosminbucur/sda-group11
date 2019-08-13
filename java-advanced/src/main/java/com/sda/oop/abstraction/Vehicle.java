package com.sda.oop.abstraction;

public abstract class Vehicle {

    private int maxSpeed;

    // no more default constructor
    public Vehicle() {
    }

    public Vehicle(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    abstract void move();
}
