package com.pds.client;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import com.pds.connection.Config;
import com.pds.boundary.Screen;

public class Client {

    private void sendToServer(Socket client, String message) throws IOException {
        OutputStream stream = client.getOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(stream);

        out.flush();
        out.writeObject(message);
    }

    public void connect(){
        try {
            Socket client = new Socket(Config.HOST, Config.PORT);

            Screen.log("Envie mensagens. Digite !sair para encerrar a conexão");

            while (true) {
                String message = Screen.read();
                sendToServer(client, message);

                if(message.equals("!sair")) break;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
