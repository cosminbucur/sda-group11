package com.bucur.exceptions.custom;

public class Car {

    public static String yearOfFabrication = "2019";
    private int speed;

    // when a threshold is reached throw exception
    public void increaseSpeed() throws CarCrashedException {
        this.speed += 70;
        if (this.speed > 280) {
            throw new CarCrashedException(this);
        }
    }

    public int getSpeed() {
        return this.speed;
    }
}
