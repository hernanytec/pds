package com.pds;

import com.pds.server.Server;
import com.pds.connection.Config;

public class MainServer {
    public static void main(String[] args) {
        Server server =  new Server();
        server.listen(Config.PORT);
    }
}
