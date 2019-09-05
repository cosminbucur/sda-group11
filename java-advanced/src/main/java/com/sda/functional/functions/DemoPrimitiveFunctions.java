package com.sda.functional.functions;

import java.util.function.IntToDoubleFunction;

/**
 * Since a primitive type can’t be a generic type argument, there are versions of the Function interface
 * for most used primitive types. You can also write your own.
 */
public class DemoPrimitiveFunctions {

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        double[] transformedArray = transformArray(array, value -> value * 2);

        for (int i = 0; i < transformedArray.length; i++) {
            System.out.println(transformedArray[i]);
        }
    }

    private static double[] transformArray(int[] array, IntToDoubleFunction function) {
        double[] transformedArray = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            transformedArray[i] = function.applyAsDouble(array[i]);
        }
        return transformedArray;
    }
}
