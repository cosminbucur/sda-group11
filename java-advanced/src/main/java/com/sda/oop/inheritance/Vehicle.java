package com.sda.oop.inheritance;

public class Vehicle {

    protected int maxSpeed;
    private int yerOfFabrication;

    // default constructor
    public Vehicle() {
    }

    // if this constructor is added, I need to explicitly declare
    // default constructor
    public Vehicle(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Vehicle(int maxSpeed, int yearOfFabrication) {
        this.maxSpeed = maxSpeed;
        this.yerOfFabrication = yearOfFabrication;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public String toString() {
        return "Vehicle (parent) {" +
                "maxSpeed=" + maxSpeed +
                ", yerOfFabrication=" + yerOfFabrication +
                '}';
    }
}
