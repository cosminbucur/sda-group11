package com.bucur.solid.interface_segregation.after;

public class DemoInterfaceSegregation {

    public static void main(String[] args) {
        Toy toyCar = new ToyCar();
        ToyPlane toyPlane = new ToyPlane();

        toyCar.setColor("blue");
        toyCar.setPrice(20);

        toyPlane.setColor("white");
        toyPlane.setPrice(50);
        toyPlane.fly();
    }
}
