package io.codeforall.fanstatics;

import java.io.*;
import java.net.*;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost"; // Endereço do servidor
    private static final int SERVER_PORT = 12345; // Porta do servidor

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Conectado ao servidor. Digite seu nome:");
            String clientName = userInput.readLine();
            out.println(clientName); // Enviar o nome do cliente para o servidor

            // Thread para ler mensagens do servidor
            new Thread(() -> {
                String serverMessage;
                try {
                    while ((serverMessage = in.readLine()) != null) {
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            // Loop para enviar mensagens para o servidor
            String userMessage;
            while (true) {
                userMessage = userInput.readLine();
                if (userMessage.equalsIgnoreCase("/quit")) {
                    out.println("/quit");
                    break;
                } else {
                    out.println(userMessage); // Enviar mensagem para o servidor
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
