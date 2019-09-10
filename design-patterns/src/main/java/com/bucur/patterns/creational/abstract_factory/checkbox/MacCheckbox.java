package com.bucur.patterns.creational.abstract_factory.checkbox;

public class MacCheckbox implements Checkbox {

    @Override
    public void paint() {
        // Render a checkbox in macOS style
        System.out.println("paint mac checkbox");
    }
}
