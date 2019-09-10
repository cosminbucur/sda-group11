package com.bucur.patterns.creational.factory_method.transports;

public class Truck implements Transport {

    @Override
    public void deliver() {
        System.out.println("truck delivering");
    }
}
