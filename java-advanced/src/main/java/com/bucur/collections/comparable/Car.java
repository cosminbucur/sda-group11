package com.bucur.collections.comparable;

public class Car implements Comparable<Car> {

    private int maxSpeed;

    public Car(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public int compareTo(Car otherCar) {
        return this.maxSpeed - otherCar.maxSpeed;
    }
}
