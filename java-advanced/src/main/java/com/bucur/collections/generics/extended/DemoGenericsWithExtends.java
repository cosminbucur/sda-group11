package com.bucur.collections.generics.extended;

public class DemoGenericsWithExtends {

    public static void main(String[] args) {
        Vehicle car = new Car();

        Vehicle bike = new Bike();

        Garage<Vehicle> garage = new Garage<>(car);
        garage.repairVehicle();

        Garage<Vehicle> garage2 = new Garage<>(bike);
        garage2.repairVehicle();

        Bike myBike = new Bike();
        Vehicle newBike;
        newBike = (Vehicle) myBike;

    }
}
