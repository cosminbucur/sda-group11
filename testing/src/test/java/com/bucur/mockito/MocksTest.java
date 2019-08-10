package com.bucur.mockito;

import com.bucur.junit4.Calculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MocksTest {

    // mock option 1
    Calculator mock = Mockito.mock(Calculator.class);

    // what is a static method?

    // mock option 2
    @Mock
    private Calculator mockCalculator;

    // import static to make this cleaner
    @Test
    public void whenAdd_thenReturnOk() {
        // GIVEN

        when(mockCalculator.add(eq(1), eq(3)))
                .thenReturn(123);
        // from now on the calculator.add(1, 3) returns 123

        // WHEN

        int actual = mockCalculator.add(1, 3);

        // THEN

        assertEquals(10, actual);

        // verify a certain behavior happened once
        verify(mockCalculator).add(anyInt(), anyInt());

    }

    @Test
    public void whenAnotherAdd_thenReturnOk() {
        // GIVEN

        when(mockCalculator.add(anyInt(), anyInt()))
                .thenReturn(456);

        // WHEN

        int actual = mockCalculator.add(4, 5);

        // THEN

        assertEquals(456, actual);

        verify(mockCalculator, times(1))
                .add(4, 5);
    }
}
