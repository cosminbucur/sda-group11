package com.bucur.fxml;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField textField;

    @FXML
    private void initialize() {
        System.out.println("controller is initialized");
        textField.setText("Controller says hi!");
    }

    @FXML
    private void onButtonClick() {
        System.out.println("click!");
    }
}
