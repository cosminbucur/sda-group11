package com.bucur.junit4.slide6;

import com.bucur.junit4.Calculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedTest {

    @Parameterized.Parameter(0)
    public int argument1;
    @Parameterized.Parameter(1)
    public int argument2;
    @Parameterized.Parameter(2)
    public int expectedArgument;

    @Parameterized.Parameters
    public static Collection<Integer[]> parameters() {
        return Arrays.asList(new Integer[][]{
                {1, 1, 2},  // scenario 1
                {2, 4, 6},  // scenario 2
                {1, 6, 7},
                {4, 1, 5}
        });
    }

    // annotation
    // method signature
    @Test
    public void givenCalculator_whenAdd_thenReturnOk() {
        // given
        Calculator calculator = new Calculator();

        // when
        int actualResult = calculator.add(argument1, argument2);

        // then
        assertEquals(expectedArgument, actualResult);
    }

}
