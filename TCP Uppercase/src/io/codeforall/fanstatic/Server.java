package io.codeforall.fanstatic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        // STEP1: Get parameters from command line arguments
        int portNumber = 8080;

        String serverMessage;
        // STEP2: Bind to local port and block while waiting for client connections
        ServerSocket serverSocket;

        {
            serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            clientSocket.getLocalPort();

            // STEP3: Setup input and output streams
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            while (true) {
                serverMessage = in.readLine();
                serverMessage = serverMessage.toUpperCase();
                System.out.println(serverMessage);
            }


        }

    }

}

