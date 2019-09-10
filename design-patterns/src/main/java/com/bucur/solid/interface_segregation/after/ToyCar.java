package com.bucur.solid.interface_segregation.after;

public class ToyCar implements Toy, Movable {

    @Override
    public void setPrice(double price) {

    }

    @Override
    public void setColor(String color) {

    }

    @Override
    public void move() {
        System.out.println("car is moving");
    }
}
