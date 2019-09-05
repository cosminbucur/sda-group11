package com.sda.multithreading.deadlock.problem;

// Resource B
public class B {
    private int i = 20;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
