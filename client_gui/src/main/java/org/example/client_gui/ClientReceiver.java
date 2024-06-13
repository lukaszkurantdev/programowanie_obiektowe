package org.example.client_gui;

public class ClientReceiver {
    public static HelloController controller;
    public static ConnectionThread thread;

    public static void receiveBroadcast(String message) {
        controller.onMessage(message);
    }
}
