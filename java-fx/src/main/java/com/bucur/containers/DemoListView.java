package com.bucur.containers;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DemoListView extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    private static VBox buildListView() {
        ListView<String> listView = new ListView<>();

        ObservableList<String> items = listView.getItems();
        items.addAll("element 1");
        items.addAll("element 2");
        items.addAll("element 3");

        VBox root = new VBox();
        root.getChildren().addAll(listView);

        root.setSpacing(10);

        return root;
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = buildListView();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
