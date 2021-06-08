package com.pds;

import com.pds.client.Client;

public class MainClient {
    public static void main(String[] args) {
        Client client = new Client();
        client.connect();
    }
}
