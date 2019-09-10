package com.bucur.oop.interfaces;

public class DemoInterface {

    public static void main(String[] args) {
        Shape shape = new Shape() {
            @Override
            public double getArea() {
                return 0;
            }

            @Override
            public double getPerimeter() {
                return 0;
            }
        };
    }
}
