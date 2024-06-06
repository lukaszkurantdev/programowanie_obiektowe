package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.Socket;

public class ConnectionThread extends Thread {
    Socket socket;
    PrintWriter writer;

    public ConnectionThread(String address, int port) throws IOException {
        socket = new Socket(address, port);
    }

    public void run() {
        try {
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(input)
            );
            writer = new PrintWriter(output,true);

            String rawMessage;
            // "{"type": "", "content": ""}"

            while((rawMessage = reader.readLine()) != null) {
                Message message = new ObjectMapper()
                        .readValue(rawMessage, Message.class);

                switch (message.type) {
                    case Broadcast -> System.out.println(message.content);
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void send(Message message) throws JsonProcessingException {
        String rawMessage = new ObjectMapper()
                .writeValueAsString(message);
        writer.println(rawMessage);
    }
}
