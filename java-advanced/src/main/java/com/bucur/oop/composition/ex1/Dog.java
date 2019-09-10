package com.bucur.oop.composition.ex1;

public class Dog {

    // aggregation
    private Muzzle muzzle;

    void putMuzzleOn(Muzzle muzzle) {
        this.muzzle = muzzle;
        System.out.println("muzzle is on");
    }
}
