package com.sda.oop.inheritance;

public class Car extends Vehicle {

    private double maxSPeed;
    private boolean convertible;

    public Car(int maxSpeed) {
        this.maxSPeed = maxSpeed;
    }

    public Car(int maxSpeed, boolean convertible) {
//        super(maxSpeed);
        super(maxSpeed, 2019);
        this.convertible = convertible;
    }

    public boolean isConvertible() {
        return convertible;
    }

    public int getParentsHiddenField() {
        int parentHiddenMaxSpeed = super.maxSpeed;
        return parentHiddenMaxSpeed;
    }

    @Override
    public String toString() {
        String parentRepresentation = super.toString();
        return parentRepresentation +
                // print child property
                " child properties: convertible=" + convertible;
    }
}
