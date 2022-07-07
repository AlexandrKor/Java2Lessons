package ru.korneev.server.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyServer {

    private final List<Socket> clientConnetions = new ArrayList<>();

    public void start(int port){
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server has been started");

            while (true) {
                waitAndProcessClientConnection(serverSocket);
            }

        }catch (IOException e) {
            System.err.println("Filed to ind port" + port);
            e.printStackTrace();
        }

    }

    private void waitAndProcessClientConnection(ServerSocket serverSocket) throws IOException {
        System.out.println("Waiting for new connections");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client has been connected");
        this.clientConnetions.add(clientSocket);
        new Thread(()-> {
            try {
                DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();


    }
}
