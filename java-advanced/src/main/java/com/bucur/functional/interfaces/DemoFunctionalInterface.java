package com.bucur.functional.interfaces;

public class DemoFunctionalInterface {

    public static void main(String[] args) {
        // lambda expression to implement functional interface.
        // This interface by default implements abstractFun()
        MyFunctionalInterface functionObject = (int x) -> System.out.println(2 * x);

        // This calls above lambda expression and prints 10.
        functionObject.abstractFun(5);
    }
}
