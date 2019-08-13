package com.bucur.junit4;

public class Person {

    private int age;

    public boolean isTeenager() {
        // implement this
        if (this.age >= 10 && this.age < 20) {
            return true;
        } else {
            return false;
        }
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }
}
