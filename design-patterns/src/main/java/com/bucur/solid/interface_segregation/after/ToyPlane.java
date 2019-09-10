package com.bucur.solid.interface_segregation.after;

public class ToyPlane implements Toy, Flyable {

    @Override
    public void setPrice(double price) {

    }

    @Override
    public void setColor(String color) {

    }

    @Override
    public void fly() {
        System.out.println("toy plane flying");
    }
}
