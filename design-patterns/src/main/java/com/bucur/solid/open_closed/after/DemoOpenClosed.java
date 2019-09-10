package com.bucur.solid.open_closed.after;

public class DemoOpenClosed {

    public static void main(String[] args) {
        ICalculator simpleCalculator = new SimpleCalculator();
        IOperation addition = new Addition(2, 3);

        simpleCalculator.calculate(addition);
    }
}
