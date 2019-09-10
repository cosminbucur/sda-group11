package com.bucur.functional.streams;

import java.util.Arrays;
import java.util.List;

/**
 * identity - an element that is the initial value of the reduction operation and the default result if the stream is empty
 * accumulator -  a function that takes two parameters: a partial result of the reduction operation and the next element of the stream
 * combiner - a function used to combine the partial result of the reduction operation when the reduction is parallelized,
 * or when there’s a mismatch between the types of the accumulator arguments and the types of the accumulator implementation
 */
public class DemoReduce {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int result = numbers
                .stream()
                .reduce(0, (subtotal, element) -> subtotal + element);
        System.out.println(result);     // 15
    }
}
