package com.bucur.exceptions.custom;

public class CarCrashedException extends Exception {

    public CarCrashedException(Car car) {
        // calling Exception(String message) constructor
        super("car " + car + " has crashed!");
    }
}
