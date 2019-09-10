package com.bucur.solid.open_closed.before;

public class Addition implements IOperation {

    private double firstOperand;
    private double secondOperand;
    private double result;

    public void setResult() {
        this.result = firstOperand + secondOperand;
    }
}
