package com.bucur.patterns.creational.abstract_factory.factory;

import com.bucur.patterns.creational.abstract_factory.button.Button;
import com.bucur.patterns.creational.abstract_factory.button.MacButton;
import com.bucur.patterns.creational.abstract_factory.checkbox.Checkbox;
import com.bucur.patterns.creational.abstract_factory.checkbox.MacCheckbox;

public class MacFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
