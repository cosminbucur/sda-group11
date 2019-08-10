package com.bucur.others;

import com.bucur.junit4.Toy;

public class DemoStatic {

    public static void main(String[] args) {
        // notStaticMethod
        Toy toy = new Toy();
        toy.notStaticMethod();

        // staticMethod
        Toy.staticMethod();
    }
}

