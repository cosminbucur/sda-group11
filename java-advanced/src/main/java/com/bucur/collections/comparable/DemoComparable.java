package com.bucur.collections.comparable;

public class DemoComparable {

    public static void main(String[] args) {
        Car audi = new Car(200);
        Car bugatti = new Car(400);

        if (audi.compareTo(bugatti) > 0) {
            System.out.println("audi is faster than bugatti");
        }
    }
}
