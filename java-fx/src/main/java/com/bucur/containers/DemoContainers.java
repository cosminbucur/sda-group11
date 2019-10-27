package com.bucur.containers;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DemoContainers extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        // create container object
        VBox vBox = new VBox();

        // create a label
        Label label = new Label("Hello World");

        // setting label to a child of the vBox container
        vBox.getChildren().add(label);

        // create a scene.  the vBox is passed as it's root container
        Scene scene = new Scene(vBox);

        // setting the main windows's scene
        stage.setScene(scene);

        // display the window
        stage.show();
    }
}
