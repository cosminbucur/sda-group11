package com.bucur.oop.enums;

public enum LengthUnit {
    METER(1, "meter unit"),
    CENTIMETER(0.01, "centimeter unit"),
    FOOT(2, "foot unit"),
    INCH(40, "inch unit");

    double value;
    String prettyName;

    LengthUnit(double value, String prettyName) {
        this.value = value;
        this.prettyName = prettyName;
    }
}
