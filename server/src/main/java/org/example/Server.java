package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private ServerSocket socket;
    List<ClientThread> clients = new ArrayList<>();

    public Server(int port) throws IOException {
        socket = new ServerSocket(port);
    }

    public void listen() throws IOException {
        while(true) {
            Socket client = socket.accept();
            ClientThread thread = new ClientThread(client, this);
            clients.add(thread);
            thread.start();
        }
    }

    public void broadcast(Message message) throws JsonProcessingException {
        for(ClientThread client : clients) {
            client.send(message);
        }
    }
}
