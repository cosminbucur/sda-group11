package com.bucur.containers;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DemoTextControls extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    private static VBox buildTextControls() {
        VBox root = new VBox();

        Button button = new Button("button");
        System.out.println(button.getText());

        TextField textField = new TextField("text field");
        System.out.println(textField.getText());

        TextArea textArea = new TextArea("text area");
        System.out.println(textArea.getText());

        Label label = new Label("label");
        System.out.println(label.getText());

        CheckBox checkBox = new CheckBox("tick me!");
        System.out.println(checkBox.getText());

        // add controls to container
        root.getChildren().addAll(button, textField, textArea, label, checkBox);

        // space between columns
        root.setSpacing(10);

        return root;
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = buildTextControls();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
