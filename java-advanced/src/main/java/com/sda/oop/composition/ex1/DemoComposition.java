package com.sda.oop.composition.ex1;
/*        Create a Muzzle class
        Create a Muzzle object
        Assign the created object to a Dog object
        How to use a Dog object to show all attributes of a Muzzle object*/

public class DemoComposition {

    // client
    public static void main(String[] args) {
        Muzzle muzzle = new Muzzle();
        Dog dog = new Dog();

        dog.putMuzzleOn(muzzle);
    }
}
