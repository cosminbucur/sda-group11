package com.bucur.fluent;

public class Car {

    private int fabricationYear;
    private double price;
    private String brand;

    public Car(int fabricationYear, double price, String brand) {
        this.fabricationYear = fabricationYear;
        this.price = price;
        this.brand = brand;
    }

    public int getFabricationYear() {
        return fabricationYear;
    }

    public Car setFabricationYear(int fabricationYear) {
        this.fabricationYear = fabricationYear;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Car setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public Car setBrand(String brand) {
        this.brand = brand;
        return this;
    }
}
