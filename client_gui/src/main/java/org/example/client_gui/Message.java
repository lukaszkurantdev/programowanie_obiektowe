package org.example.client_gui;


public class Message {
    public MessageType type;
    public String content;

    public Message() {}

    public Message(MessageType type, String content) {
        this.type = type;
        this.content = content;
    }
}
