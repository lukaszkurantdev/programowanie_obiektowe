package org.example.k2_client;

public class ClientReceiver {
    public static HelloController controller;
    public static ConnectionThread thread;

    public static void receiveWord(String message) {
        controller.onWordReceived(message);
    }
}