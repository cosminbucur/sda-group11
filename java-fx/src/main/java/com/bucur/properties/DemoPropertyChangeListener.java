package com.bucur.properties;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.stage.Stage;

public class DemoPropertyChangeListener extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    private static void usePropertyChangeListener() {
        // create a string property
        SimpleStringProperty stringProperty = new SimpleStringProperty("initial value");

        // print property value
        System.out.println(stringProperty.getValue());

        // add a listener - action that will run if the property changes
        stringProperty.addListener((observable, oldValue, newValue) -> {
            System.out.println("new vlaue is set: " + newValue);
        });

        // set new value
        stringProperty.setValue("some new value");
    }

    @Override
    public void start(Stage stage) throws Exception {
        usePropertyChangeListener();
    }
}
