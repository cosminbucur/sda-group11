package com.sda.objects;

public class DemoFor {

    public static void main(String[] args) {
        //               0  1  2
        int[] myArray = {1, 2, 3};

        // for (from what?; until when?; increment step)
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }
    }
}
