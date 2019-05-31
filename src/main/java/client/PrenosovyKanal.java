package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;



public class PrenosovyKanal {

     public int prijmaciPortServer = 6666;

    public void zasielac(String Sprava){
        Socket posielaciSocket;
        PrintWriter posielaciOut;
        BufferedReader posielaciIn;

        try{
            posielaciSocket = new Socket("localhost", prijmaciPortServer);
            posielaciOut = new PrintWriter(posielaciSocket.getOutputStream(), true);
            posielaciIn = new BufferedReader(new InputStreamReader(posielaciSocket.getInputStream()));

            posielaciOut.println(Sprava);

            posielaciIn.close();
            posielaciOut.close();
            posielaciSocket.close();

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

}
