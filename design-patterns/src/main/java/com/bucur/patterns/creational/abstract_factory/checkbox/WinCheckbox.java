package com.bucur.patterns.creational.abstract_factory.checkbox;

public class WinCheckbox implements Checkbox {

    @Override
    public void paint() {
        // Render a checkbox in Windows style
        System.out.println("paint windows checkbox");
    }
}
