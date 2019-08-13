package com.sda.oop.encapsulation;

public class DemoEncapsulation {

    public static void main(String[] args) {
        Dog dog = new Dog("fido");
        Dog dog2 = new Dog("male", "bulldog");

        Dog fido = new Dog("fido", "male", "bulldog");
        System.out.println(fido);
    }
}
