package com.bucur.oop.interfaces;

public interface Shape {

    // every variable is public static final (constant)
    public static final int LENGTH = 1;
    int WIDTH = 2;

    // public is redundant
    public double getArea();

    double getPerimeter();
}
