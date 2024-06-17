package org.example.k2_client;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class HelloController {
    public Label wordCountLabel;

    public HelloController() {
        ClientReceiver.controller = this;
    }

    List<Word> listOfWords = new ArrayList<Word>();

    public void onWordReceived(String word) {
        listOfWords.add(new Word(word, LocalTime.now()));

        Platform.runLater(()->{wordCountLabel.setText(String.valueOf(listOfWords.size()));});
    }
}