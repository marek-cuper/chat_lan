package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class PrijmaciKanal {

    public ServerSocket prijmaciServerSocket;
    private Socket prijmaciClientSocket;
    private PrintWriter prijmaciOut;
    private BufferedReader prijmaciIn;


    public void otvoreniePrijmaciehoKanalu(int port){


        try{
            prijmaciServerSocket = new ServerSocket(port);
            prijmaciClientSocket = prijmaciServerSocket.accept();
            prijmaciOut = new PrintWriter(prijmaciClientSocket.getOutputStream(), true);
            prijmaciIn = new BufferedReader(new InputStreamReader(prijmaciClientSocket.getInputStream()));

        } catch (IOException e) {
            e.printStackTrace();

        }
    }


    public void uzatvoreniePrijmaciehoKanalu(){

        try{
            prijmaciIn.close();
            prijmaciOut.close();
            prijmaciClientSocket.close();
            prijmaciServerSocket.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public BufferedReader getPrijmaciIn() {
        return prijmaciIn;
    }
}
