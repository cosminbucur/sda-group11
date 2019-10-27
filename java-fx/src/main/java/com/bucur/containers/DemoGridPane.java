package com.bucur.containers;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DemoGridPane extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    private static GridPane buildGridPane() {
        GridPane root = new GridPane();

        root.add(new TextField("Element 1, 1"), 0, 0);
        root.add(new Label("Element 1, 2"), 1, 0);
        root.add(new TextField("Element 2, 1"), 0, 1);
        root.add(new Label("Element 2, 2"), 1, 1);
        return root;
    }

    @Override
    public void start(Stage stage) throws Exception {
        GridPane root = buildGridPane();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
