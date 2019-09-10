package com.bucur.oop.enums;

public class DemoEnum {

    public static void main(String[] args) {
//        countDistance(LengthUnit.CENTIMETER);
//        countDistance(LengthUnit.METER);

        System.out.println(LengthUnit.METER.prettyName);
        System.out.println(LengthUnit.METER.value);
    }

    private static void countDistance(LengthUnit lengthUnit) {
        int distance = 20;

        System.out.println("distance is: " + distance + " " + lengthUnit.name());

//        System.out.println(distance + LengthUnit.METER.name().toLowerCase());
    }

    private static void countHeight() {
        int height = 10;

        System.out.println(height + "stanjeni");
    }

    // print a student's age
    private void printStudentAge(Student student) {
        System.out.println("student age = " + student.getAge());
    }
}
