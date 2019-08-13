package com.sda.oop.encapsulation;

public class Dog {

    private String name;
    private int age;
    private String gender;
    private String race;
    private int weight;

    public Dog(String newName) {
        this.name = newName;
    }

    // TODO: use super
    public Dog(String gender, String race) {
        this.gender = gender;
        this.race = race;
    }

    public Dog(String name, String gender, String race) {
        // check properties that will never change
        if (name != null) {
            this.name = name;
        }

        if (gender != null) {
            this.gender = gender;
        }

        if (race != null) {
            this.race = race;
        }

        // checked in setter
        // default values for all new born dogs
        this.age = 0;
        this.weight = 1;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        // check property that might change
        if (age > 0) {
            this.age = age;
        }
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight > 0) {
            this.weight = weight;
        }
    }

    @Override
    public String toString() {
        return "My new dog has the following properties: {" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", race='" + race + '\'' +
                ", weight=" + weight +
                '}';
    }
}
