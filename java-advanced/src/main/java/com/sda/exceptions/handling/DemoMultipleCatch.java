package com.sda.exceptions.handling;

public class DemoMultipleCatch {

    public static void main(String[] args) {
        divide();
        divide2();
    }

    private static void divide() {
        // declare: type + name = assignment
        //                0  1  2
        int[] intArray = {1, 2, 3};
        int y = 0;

        try {
            int x = intArray[1] / y;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("this item doesn't exist");
        } catch (ArithmeticException e) {
            System.out.println("check your math");
        } catch (Exception e) {
            System.out.println("you must be crazy");
        }
    }

    private static void divide2() {
        // declare: type + name = assignment
        //                0  1  2
        int[] intArray = {1, 2, 3};
        int y = 0;

        try {
            int x = intArray[1] / y;
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("this item doesn't exist");
        }
    }
}
