package com.sda.exceptions.custom;

public class DemoCustomException {

    public static void main(String[] args) throws Exception {
        Car porche = new Car();

        // class variable
        System.out.println(Car.yearOfFabrication);

        // instance variable
        System.out.println("porche speed = " + porche.getSpeed());
        porche.increaseSpeed();
        porche.increaseSpeed();
        porche.increaseSpeed();
        porche.increaseSpeed();
        porche.increaseSpeed();
        porche.increaseSpeed();

        System.out.println("porche speed = " + porche.getSpeed());

        Car audi = new Car();
        audi.getSpeed();
        System.out.println("audi speed = " + audi.getSpeed());

    }
}
