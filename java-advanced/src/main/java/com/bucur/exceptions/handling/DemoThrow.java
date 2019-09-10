package com.bucur.exceptions.handling;

public class DemoThrow {

    public static void main(String[] args) {
        try {
            activate();
        } catch (NullPointerException e) {
            System.out.println("caught in main()");
        }
    }

    public static void activate() {
        try {
            throw new NullPointerException("something is null");
        } catch (NullPointerException e) {
            System.out.println("caught in activate()");

            // rethrow the exception
            throw e;
        }
    }
}
