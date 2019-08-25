package com.sda.collections.generics;

public class DemoGenerics {

    public static void main(String[] args) {
        Car car = new Car();

        GenericBox<Car> oldGenericBox = new GenericBox<Car>(car);

        GenericBox<Car> genericBox = new GenericBox<>(car);
    }
}
