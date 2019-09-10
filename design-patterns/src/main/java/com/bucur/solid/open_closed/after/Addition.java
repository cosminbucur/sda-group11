package com.bucur.solid.open_closed.after;

public class Addition implements IOperation {

    private double firstOperand;
    private double secondOperand;
    private double result;

    public Addition(double firstOperand, double secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    @Override
    public void performOperation() {
        this.result = firstOperand + secondOperand;
    }
}
