package org.example.k2_client;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HelloController {
    public Label wordCountLabel;
    public TextField filterField;
    public ListView wordList;

    public HelloController() {
        ClientReceiver.controller = this;
    }

    List<Word> listOfWords = new ArrayList<Word>();

    public void onWordReceived(String word) {
        listOfWords.add(new Word(word, LocalTime.now()));

        Platform.runLater(()->{
            wordCountLabel.setText(String.valueOf(listOfWords.size()));
            update();
        });
    }

    public void update() {
        DateTimeFormatter formatter;
        formatter = DateTimeFormatter.ofPattern("HH:mm:ss ");
        wordList.setItems(FXCollections.observableArrayList(
                listOfWords.stream()
                        .sorted((word1, word2) -> word1.string.compareTo(word2.string))
                        .map((item) -> item.time.format(formatter) + item.string)
                        .toList()
        ));
    }
}