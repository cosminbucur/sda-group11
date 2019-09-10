package com.bucur.patterns.creational.abstract_factory.factory;

import com.bucur.patterns.creational.abstract_factory.button.Button;
import com.bucur.patterns.creational.abstract_factory.checkbox.Checkbox;

public interface GUIFactory {

    Button createButton();

    Checkbox createCheckbox();
}
