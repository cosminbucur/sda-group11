package com.bucur.fluent;

public class DemoFluentAPI {

    public static void main(String[] args) {
        Car car = new Car(2010, 5000.99, "ford");

        car.setFabricationYear(2019)
                .setPrice(80000.99)
                .setBrand("BMW");

        System.out.println("Fabrication year: " + car.getFabricationYear());
        System.out.println("Price: " + car.getPrice());
        System.out.println("Brand: " + car.getBrand());
    }
}
