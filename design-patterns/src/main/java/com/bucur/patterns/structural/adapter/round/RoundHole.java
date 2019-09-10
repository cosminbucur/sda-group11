package com.bucur.patterns.structural.adapter.round;

public class RoundHole {

    private double radius;

    public RoundHole() {
    }

    public RoundHole(double radius) {
        this.radius = radius;
    }

    public boolean fits(RoundPeg roundPeg) {
        return getRadius() >= roundPeg.getRadius();
    }

    public double getRadius() {
        return radius;
    }
}
