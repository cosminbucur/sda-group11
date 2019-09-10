package com.bucur.statics;

public class DemoStatic {

    public static void main(String[] args) {
        System.out.println("count = " + Car.count);

        Car porche = new Car();
        porche.speed = 200;

        System.out.println("count = " + Car.count);

        Car audi = new Car();
        audi.speed = 100;

        System.out.println("count = " + Car.count);

        System.out.println(Car.year);
        System.out.println("porche speed = " + porche.speed);
        System.out.println("audi speed = " + audi.speed);
    }
}
