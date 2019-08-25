package com.sda.exceptions.handling;

public class DemoExceptions {

    public static void main(String[] args) {
        divide(4, 2);
        divide(4, 0);
    }

    private static int divide(int x, int y) {
        int result = 0;
        try {
            // this code might not work
            result = x / y;
            System.out.println("the result is " + result);
            return result;
        } catch (Exception e) {
            // handle exception
            System.out.println("the message is: " + e.getMessage());
            System.out.println("the cause is: " + e.getCause());
            e.printStackTrace();
        } finally {
            System.out.println("this happens no matter what");
        }
        return result;
    }
}
