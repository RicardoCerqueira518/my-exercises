package io.codeforall.fanstatics;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class ChatServer {
    private static final int PORT = 12345;
    private static Set<PrintWriter> clientWriters = ConcurrentHashMap.newKeySet();
    private static Map<String, PrintWriter> clients = new ConcurrentHashMap<>();
    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        System.out.println("Servidor iniciado...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                executor.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String clientName;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                synchronized (clients) {
                    // Nome do cliente
                    out.println("Digite seu nome:");
                    clientName = in.readLine();
                    clients.put(clientName, out);
                    clientWriters.add(out);
                    System.out.println("Cliente: " + clientName + " conectado");
                    broadcast(clientName + " entrou no chat.");
                }

                String message;
                while ((message = in.readLine()) != null) {
                    if (message.startsWith("/list")) {
                        listClients();
                    } else if (message.startsWith("/whisper")) {
                        whisperMessage(message);
                    } else if (message.startsWith("/quit")) {
                        quit();
                        break;
                    } else if (message.startsWith("/help")) {
                        showHelp();
                    } else {
                        broadcast(clientName + ": " + message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                cleanup();
            }
        }

        private void listClients() {
            StringBuilder clientList = new StringBuilder("Usuários conectados: ");
            for (String name : clients.keySet()) {
                clientList.append(name).append(" ");
            }
            out.println(clientList.toString());
        }

        private void whisperMessage(String message) {
            String[] parts = message.split(" ", 3);
            if (parts.length < 3) {
                out.println("Uso: /whisper <nome> <mensagem>");
                return;
            }
            String recipientName = parts[1];
            String whisper = parts[2];

            PrintWriter recipientWriter = clients.get(recipientName);
            if (recipientWriter != null) {
                recipientWriter.println("[Whisper from " + clientName + "] " + whisper);
            } else {
                out.println("Usuário " + recipientName + " não encontrado.");
            }
        }

        private void showHelp() {
            out.println("Comandos disponíveis:");
            out.println("/list - Lista todos os usuários conectados.");
            out.println("/whisper <nome> <mensagem> - Envia uma mensagem privada para um usuário.");
            out.println("/quit - Sai do chat.");
            out.println("/help - Mostra esta lista de comandos.");
        }

        private void quit() {
            out.println("Você saiu do chat.");
            cleanup();
        }

        private void broadcast(String message) {
            for (PrintWriter writer : clientWriters) {
                writer.println(message);
            }
        }

        private void cleanup() {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            synchronized (clients) {
                clients.remove(clientName);
                clientWriters.remove(out);
                broadcast(clientName + " saiu do chat.");
            }
        }
    }
}
