package com.bucur.junit4.slide3;

import com.bucur.junit4.Calculator;
import com.bucur.junit4.Car;
import org.junit.Test;

import java.util.Random;

public class ExceptionTest {

    @Test(expected = ArithmeticException.class)
    public void shouldThrowExceptionWhenDividingBy0() {
        // given
        Calculator calculator = new Calculator();
        int number = new Random().nextInt();
        // when
        calculator.divide(number, 0);
        // then
        // should throw exception
    }

    // use tests to learn how stuff works
    @Test
    public void whatIsClass() {
        System.out.println("object that represents the class at runtime: " + Car.class);
        System.out.println("name of the object: " + Car.class.getName());

        Car instanceOfCar = new Car();
        System.out.println("same object returned by ani instance " + instanceOfCar.getClass().getName());
    }
}
