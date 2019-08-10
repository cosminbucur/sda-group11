package com.bucur.junit4;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @BeforeClass
    public static void setup() {

    }

    @Test
    public void whenAdd_shouldReturnOk() {
        // given
        Calculator calculator = new Calculator();
        int expected = 5;

        // when
        int actual = calculator.add(2, 3);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void whenSubtract_shouldReturnOk() {
        // given
        Calculator calculator = new Calculator();
        int expected = 2;

        // when
        int actual = calculator.subtract(5, 3);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void whenMultiply_shouldReturnOk() {
        // given
        Calculator calculator = new Calculator();
        int expected = 12;

        // when
        int actual = calculator.multiply(3, 4);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionWhenDividingBy0() {
        // given
        expectedException.expect(ArithmeticException.class);
        expectedException.expectMessage("/ by zero");
        Calculator calculator = new Calculator();
        int number = new Random().nextInt();

        // when
        calculator.divide(number, 0);

        // then
        // should throw expected exception
    }


}
