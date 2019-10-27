package com.bucur.properties;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DemoSliderPropertyBinding extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    private static VBox useSliderPropertyBinding() {
        Slider slider = new Slider();
        Label label = new Label("my label");
        VBox root = new VBox();

        // slider value affects the space between itself and the label
        root.spacingProperty().bind(slider.valueProperty());
        root.getChildren().addAll(slider, label);

        return root;
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = useSliderPropertyBinding();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
