package com.bucur.patterns.structural.facade.fuel;

public class FuelInjector {

    FuelPump fuelPump;

    public void on() {
        System.out.println("fuel injector: on");
    }

    public void inject() {
        System.out.println("fuel injector: inject");

    }

    public void off() {
        System.out.println("fuel injector: off");

    }
}
