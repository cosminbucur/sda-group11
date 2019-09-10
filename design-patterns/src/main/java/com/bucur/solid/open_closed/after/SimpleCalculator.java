package com.bucur.solid.open_closed.after;

import java.security.InvalidParameterException;

public class SimpleCalculator implements ICalculator {

    @Override
    public void calculate(IOperation operation) {
        if (operation == null) {
            throw new InvalidParameterException();
        }
        operation.performOperation();
    }
}
