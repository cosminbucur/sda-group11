package com.bucur.oop.story.andreea;

public class Pony {

    private String name;

    public Pony(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println("Pony eating: munch munch");
    }

    public void sleep() {

    }

    // the name can not be changed after birth so I only have a getter
    public String getName() {
        return name;
    }
}
