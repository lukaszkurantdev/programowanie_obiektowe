package org.example.k2_client;

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

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}