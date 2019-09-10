package com.bucur.statics;

public class Car {

    static int year = 2019;
    static int count;

    public int speed;

    public Car() {
        count++;
    }

    @Override
    public String toString() {
        return "Car{" +
                "speed=" + speed +
                '}';
    }
}

