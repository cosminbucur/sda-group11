package com.bucur;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// extend application
public class DemoJavaFx extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // set stage (window) properties
        stage.setTitle("JavaFX Application");
        stage.setWidth(400);
        stage.setHeight(200);

        // create container
        VBox vBox = new VBox();
        Label label = new Label("Hello world!");
        vBox.getChildren().add(label);

        // create scene
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }
}
