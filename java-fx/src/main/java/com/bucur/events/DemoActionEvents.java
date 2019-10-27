package com.bucur.events;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DemoActionEvents extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    private static VBox buildVBoxWithActionEvent() {
        Button button = new Button("press me");
        button.setOnAction(event -> System.out.println("click!"));

        VBox root = new VBox();
        root.getChildren().add(button);

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
