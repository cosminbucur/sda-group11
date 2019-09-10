package com.bucur.functional.interfaces;

@FunctionalInterface
public interface MyFunctionalInterface {

    // An abstract function
    void abstractFun(int x);

    // A non-abstract (or default) function
    default void normalFun() {
        System.out.println("Hello");
    }
}
