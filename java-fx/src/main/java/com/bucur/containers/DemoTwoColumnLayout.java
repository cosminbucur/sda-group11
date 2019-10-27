package com.bucur.containers;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DemoTwoColumnLayout extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    private static HBox buildTwoColumnLayout() {
        // first column
        VBox column1 = new VBox();
        ObservableList<Node> column1Children = column1.getChildren();
        column1Children.add(new Label("Element 1, 1"));
        column1Children.add(new TextField("Element 1, 2"));

        // second column
        VBox column2 = new VBox();
        ObservableList<Node> column2Children = column2.getChildren();
        column2Children.add(new Label("Element 2, 1"));
        column2Children.add(new TextField("Element 2, 2"));

        // horizontal container for columns
        HBox root = new HBox();
        ObservableList<Node> rootChildren = root.getChildren();
        rootChildren.add(column1);
        rootChildren.add(column2);

        // space between columns
        root.setSpacing(10);

        return root;
    }

    @Override
    public void start(Stage stage) throws Exception {
        HBox root = buildTwoColumnLayout();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
