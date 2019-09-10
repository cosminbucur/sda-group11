package com.bucur.methods;

public class DemoMethods {

    // reference to MyObject
    MyObject myObject;      // null

    public DemoMethods() {
        // 1. call method from same class
        createObject();

        // 2. call method from another class
        // apeleaza doStuff din obiectul MyObject

        // reference.method
        myObject.doStuff();

        // 3. call a static method from the same object
        doStaticWork();

        // 4. call a static method from another object
        // class name.static method
        MyObject.staticMethodFromAnotherObject();
    }

    private static void doStaticWork() {
        System.out.println("really static stuff");
    }

    private void createObject() {
        // initialization
        myObject = new MyObject();
    }
}
