package com.bucur.properties;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.stage.Stage;

public class DemoBidirectionalBinding extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    private static void useUnidirectionalBinding() {
        SimpleStringProperty property1 = new SimpleStringProperty();
        SimpleStringProperty property2 = new SimpleStringProperty();

        // bidirectional binding of property 1 and 2
        property2.bindBidirectional(property1);

        // change property 1 value
        property1.setValue("some new value");

        // property 2 will be changed as well
        System.out.println(property2.getValue());

        // analogically
        property2.setValue("some other new value");

        System.out.println(property1.getValue());
    }

    @Override
    public void start(Stage stage) throws Exception {
        useUnidirectionalBinding();
    }
}
