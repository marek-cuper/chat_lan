package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class PosielacSpravy {
    public static void poslanieSpravy( String text) {
        Socket clientSocket;
        PrintWriter out;
        BufferedReader in;



        try {
            clientSocket = new Socket("localhost", 6667);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            if (text.equals("koniec")) {
                out.println(text);
                in.close();
                out.close();
                clientSocket.close();



            } else{

                out.println(text);
            }




        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
