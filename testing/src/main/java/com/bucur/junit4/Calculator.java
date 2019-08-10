package com.bucur.junit4;

public class Calculator {

    public int add(int first, int second) {
        return first + second;
    }

    public int subtract(int x, int y) {
        return x - y;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("/ by zero");
        }
        return a / b;
    }
}
