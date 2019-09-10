package com.bucur.patterns.creational.abstract_factory.factory;

import com.bucur.patterns.creational.abstract_factory.button.Button;
import com.bucur.patterns.creational.abstract_factory.button.WinButton;
import com.bucur.patterns.creational.abstract_factory.checkbox.Checkbox;
import com.bucur.patterns.creational.abstract_factory.checkbox.WinCheckbox;

public class WinFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WinCheckbox();
    }
}
