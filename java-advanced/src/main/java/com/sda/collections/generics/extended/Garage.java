package com.sda.collections.generics.extended;

public class Garage<T extends Vehicle> {

    private T vehicle;

    public Garage(T newVehicle) {
        this.vehicle = newVehicle;
    }

    public void repairVehicle() {
        this.vehicle.repair();
    }
}
