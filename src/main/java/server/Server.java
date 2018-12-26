package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    static private boolean running = true;

    public static void main(String[] args) {

        ServerSocket serverSocket;
        Socket clientSocket;
        PrintWriter out;
        BufferedReader in;

        try {
            serverSocket = new ServerSocket(6666);


            while(running) {

                clientSocket = serverSocket.accept();
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String greeting = in.readLine();

                if (greeting.equals("koniec")) {
                    in.close();
                    out.close();
                    clientSocket.close();
                    serverSocket.close();
                    running = false;

                } else{
                    System.out.println(greeting);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
            // TODO: add logging

        }
    }
}