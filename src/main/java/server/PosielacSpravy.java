package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class PosielacSpravy {
    static int prijmaciPortServer = 6667;
    public static void poslanieSpravy( String text) {
        Socket posielaciSocket;
        PrintWriter posielaciOut;
        BufferedReader posielaciIn;
        if(text!=null){
            try{
                posielaciSocket = new Socket("localhost", prijmaciPortServer);
                posielaciOut = new PrintWriter(posielaciSocket.getOutputStream(), true);
                posielaciIn = new BufferedReader(new InputStreamReader(posielaciSocket.getInputStream()));

                posielaciOut.println(text);

                posielaciIn.close();
                posielaciOut.close();
                posielaciSocket.close();

            }catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
