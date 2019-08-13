package com.sda.oop.inheritance;

public class DemoInheritance {

    public static void main(String[] args) {
        testObjectProperties();

        printPropertiesOfVehicles();

        testObjectInheritance();

        Car myCar = new Car(120);
//        printMaxSpeed(myCar);

        printWithPrefix("C01", myCar);
    }

    private static void printMaxSpeed(Car car) {
        System.out.println(car.maxSpeed);
    }

    private static void printWithPrefix(String code, Vehicle vehicle) {
        System.out.println(code + vehicle.toString());
    }

    private static void testObjectInheritance() {
        Vehicle myCarVehicle = new Car(150, true);
        System.out.println(myCarVehicle);
    }

    private static void printPropertiesOfVehicles() {
        Vehicle vehicle = new Vehicle();
        Car car = new Car(150, true);
        System.out.println("string representation of car: " + car);
        System.out.println("parent max speed : " + vehicle.getMaxSpeed());
        System.out.println("child max speed (from parent) : " + car.getMaxSpeed());
        System.out.println("parent max speed : " + car.isConvertible());
    }

    private static void testObjectProperties() {
        Object object = new Object();
        object.toString();
    }
}
