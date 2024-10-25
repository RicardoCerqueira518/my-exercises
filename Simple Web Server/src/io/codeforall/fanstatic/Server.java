package io.codeforall.fanstatic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        int portNumber = 8081;

        ServerSocket serverSocket = new ServerSocket(portNumber);
        System.out.println("Servidor rodando na porta " + portNumber);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("oaishda");
            System.out.println("Cliente conectado: " + clientSocket.getInetAddress());
            System.out.println(clientSocket.getPort());

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String requestLine = in.readLine();
            if (requestLine != null && requestLine.startsWith("GET")) {
                String[] requestParts = requestLine.split(" ");
                String requestedResource = requestParts[1].substring(1); // Remove a barra inicial

                // Serve o arquivo solicitado ou index.html se não houver arquivo
                if (requestedResource.isEmpty()) {
                    requestedResource = "index.html"; // Serve o HTML padrão
                }

                File file = new File("src/io/codeforall/fanstatic/" + requestedResource);
                System.out.println("REQUESTED FILE: " + file.getAbsolutePath());

                String contentType = getResourceExtension(requestedResource);

                if (file.exists() && !file.isDirectory() && isValidResourceExtension(contentType)) {
                    byte[] fileContent = readFile(file);
                    out.println("HTTP/1.0 200 OK");
                    out.println("Content-Type: " + contentType);
                    out.println("Content-Length: " + fileContent.length);
                    out.println();
                    out.flush();
                    clientSocket.getOutputStream().write(fileContent); // Envia o conteúdo do arquivo
                } else {
                    send404(out, clientSocket.getOutputStream());
                }
            }
            clientSocket.close();
        }
    }

    private static String getResourceExtension(String fileName) {
        if (fileName.endsWith(".html")) {
            return "text/html; charset=UTF-8";
        }
        if (fileName.endsWith(".png")) {
            return "image/png";
        }
        if (fileName.endsWith(".ico")) {
            return "image/x-icon"; // Tipo para favicon
        }
        return "application/octet-stream"; // Tipo padrão
    }

    private static boolean isValidResourceExtension(String contentType) {
        return contentType.equals("text/html; charset=UTF-8") ||
                contentType.equals("image/png") ||
                contentType.equals("image/x-icon");
    }

    private static byte[] readFile(File file) {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] fileContent = new byte[(int) file.length()];
            fileInputStream.read(fileContent);
            return fileContent;
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }


    private static void send404(PrintWriter out, java.io.OutputStream outputStream) {
        File file = new File("src/io/codeforall/fanstatic/404.html");
        try {
            String contentType = getResourceExtension("404.html");
            byte[] fileContent = readFile(file);

            out.println("HTTP/1.0 404 Not Found");
            out.println("Content-Type: " + contentType);
            out.println("Content-Length: " + fileContent.length);
            out.println();
            out.flush();
            outputStream.write(fileContent); // Envia o conteúdo do 404.html
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
