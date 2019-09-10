package com.bucur.solid.open_closed.after;

public class Subtraction implements IOperation {

    private double firstOperand;
    private double secondOperand;
    private double result;

    public Subtraction(double firstOperand, double secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    @Override
    public void performOperation() {
        this.result = firstOperand - secondOperand;
    }
}
