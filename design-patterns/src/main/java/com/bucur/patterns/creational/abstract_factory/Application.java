package com.bucur.patterns.creational.abstract_factory;

import com.bucur.patterns.creational.abstract_factory.button.Button;
import com.bucur.patterns.creational.abstract_factory.checkbox.Checkbox;
import com.bucur.patterns.creational.abstract_factory.factory.GUIFactory;

public class Application {

    private GUIFactory factory;

    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        this.factory = factory;
    }

    void createUI() {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    void paint() {
        button.paint();
        checkbox.paint();
    }
}
