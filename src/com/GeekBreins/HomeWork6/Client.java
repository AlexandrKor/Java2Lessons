package com.GeekBreins.HomeWork6;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public static void main(String[] args) throws IOException {
        new Client().start("localhost", Server.port);
    }

    public void start(String host, int port) throws IOException {
        Socket socket = null;
        Thread inputThread = null;
        try {
            socket = new Socket(host, port);
            System.out.println("Клиент запущен");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            inputThread = runInputThread(in);
            runOutputLoop(out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputThread != null) inputThread.interrupt();
            if (socket != null) socket.close();
        }
    }

    private Thread runInputThread(DataInputStream in) throws IOException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    String message = in.readUTF();
                    System.out.println("From server: " + message);
                    if (message.toLowerCase().startsWith("/end")) {
                        System.out.println("Сервер завершил свою работу");
                        System.exit(0);
                    }
                } catch (IOException e) {
                    System.out.println("подключение прервано");
                    System.exit(0);
                    break;
                }
            }

        });
        thread.start();
        return thread;
    }

    private void runOutputLoop(DataOutputStream out) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String message = scanner.nextLine();
            out.writeUTF(message);
            if (message.startsWith("/end")) {
                break;
            }
        }
    }
}