package com.bucur.properties;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DemoProperties extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    private static VBox buildVBoxWithProperties() {
        VBox root = new VBox();

        // set text property on text field
        TextField textField = new TextField("Initial text value");
        System.out.println(textField.getText());
        textField.setText("new value");

        StringProperty textProperty = textField.textProperty();

        root.getChildren().add(textField);

        return root;
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = buildVBoxWithProperties();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
