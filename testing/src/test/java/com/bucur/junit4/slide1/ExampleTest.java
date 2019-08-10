package com.bucur.junit4.slide1;

import com.bucur.junit4.Calculator;
import org.junit.Test;

public class ExampleTest {

    @Test
    public void test() {
        // given
        Calculator calculator = new Calculator();
        // when
        int result = calculator.add(5, 3);
        // then
        assert result == 8;
    }

    @Test
    public void test2() {
        // given
        Calculator calculator = new Calculator();
        // when
        int result = calculator.divide(4, 2);
        // then
        assert result == 2;
    }
}
