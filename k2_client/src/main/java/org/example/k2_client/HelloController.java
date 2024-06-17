package org.example.k2_client;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    public HelloController() {
        ClientReceiver.controller = this;
    }

    public void onWordReceived(String word) {

    }
}