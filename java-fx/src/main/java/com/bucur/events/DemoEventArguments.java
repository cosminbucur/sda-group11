package com.bucur.events;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DemoEventArguments extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    private static VBox buildVBoxWithActionEvent() {
        TextField textField = new TextField();
        // print the key code in the console if the key is pressed
        textField.setOnKeyReleased(event -> System.out.println(event.getCode()));

        VBox root = new VBox();
        root.getChildren().add(textField);

        return root;
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = buildVBoxWithActionEvent();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
