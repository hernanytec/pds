package com.pds.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import com.pds.boundary.Screen;

public class Server {
    ServerSocket server;

    private String receiveMessage(Socket client) throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(client.getInputStream());
        String message = (String)input.readObject();
        return message;
    }

    private void onDisconnectClient(Socket client) throws IOException {
        client.close();
        Screen.log("Cliente desconectado!");
    }

    private void handleClient(Socket client) throws IOException, ClassNotFoundException {
        while (!client.isClosed()) {
            String message = receiveMessage(client);

            if (message.equals("!sair")) {
                onDisconnectClient(client);
                break;
            }

            Screen.log("Mensagem recebida: " + message);
        }
    }

    private void onConnectClient(Socket client){
        new Thread(() -> {
            try {
                handleClient(client);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void awaitClientConnection() throws IOException, ClassNotFoundException {
        while (true) {
            Socket client = server.accept();
            Screen.log("Cliente conectado: " + client.getInetAddress().getHostAddress());
            onConnectClient(client);
        }
    }

    public void listen(int port) {
        try {
            server = new ServerSocket(port);
            Screen.log("Servidor iniciado na porta " + port);

            awaitClientConnection();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            Screen.log("Servidor encerrado!");
        }
    }
}
