package org.example.client_gui;

import com.fasterxml.jackson.core.JsonProcessingException;
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
    public void onSendPress() throws JsonProcessingException {
        String message = textField.getText();
        textArea.appendText(message + "\n");
        textField.clear();

        Message messageToSend = new Message(
                MessageType.Broadcast, message);
        ClientReceiver.thread.send(messageToSend);
    }

    public void onMessage(String message) {
        textArea.appendText(message + "\n");
    }
}