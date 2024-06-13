package org.example.client_gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    public TextArea textArea;
    public TextField textField;

    public HelloController() {
        ClientReceiver.controller = this;
    }

    @FXML
    public void onSendPress() {
        String message = textField.getText();
        textArea.appendText(message + "\n");
        textField.clear();
    }

}