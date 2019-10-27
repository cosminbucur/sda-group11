package com.bucur.properties;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.stage.Stage;

public class DemoUnidirectionalBinding extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    private static void useUnidirectionalBinding() {
        SimpleStringProperty property1 = new SimpleStringProperty("initial value");
        SimpleStringProperty property2 = new SimpleStringProperty();

        // property 2 will follow property 1 value
        property2.bind(property1);

        System.out.println(property2.getValue());

        // change property 1 value
        property1.setValue("some new value");

        // property 2 will be changed as well
        System.out.println(property2.getValue());
    }

    @Override
    public void start(Stage stage) throws Exception {
        useUnidirectionalBinding();
    }
}
