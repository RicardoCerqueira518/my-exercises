package io.codeforall.fanStatics;



import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.util.Arrays;

public class Server {

    private String message;

    public void messageToUpperCase() {
        this.message = message;

        // STEP1: Get your host and port
        String hostName = "localhost";
        int foreignPort;
        int localPort = 8080; //Servidor

        // STEP2: Create send and receive buffers
        byte[] sendBuffer = new byte[1024];
        byte[] recvBuffer = new byte[1024];
        String string;

        // STEP3: Open a UDP (datagram) socket
        DatagramSocket socket;

        {
            try {
                socket = new DatagramSocket(localPort);
                // STEP4.1: Create and receive UDP datagram packet from the socket
                DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);
                socket.receive(receivePacket); // blocks while packet not received


                string = new String(recvBuffer, 0, recvBuffer.length);

                string = string.toUpperCase().trim();
                System.out.println(string);


                // STEP4.2: Create and send UDP datagram packet from the socket
                sendBuffer = string.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, receivePacket.getAddress(), receivePacket.getPort());

                socket.send(sendPacket);

                // STEP5: Close the socket
                socket.close();


            } catch (SocketException e) {
                throw new RuntimeException(e);
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}

