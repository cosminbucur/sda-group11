package com.bucur.patterns.structural.adapter.round;

public class RoundPeg {

    private double radius;

    // this is the first constructor used when creating a child instance
    public RoundPeg() {
    }

    // if this constructor exists, the default constructor must be explicitly created
    public RoundPeg(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
