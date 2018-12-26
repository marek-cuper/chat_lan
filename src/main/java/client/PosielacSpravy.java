package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PosielacSpravy {
    public static void poslanieSpravy(String Pouzivatel, String text) {
        Socket clientSocket;
        PrintWriter out;
        BufferedReader in;
//        Client c1 = new Client();

        //GreetClient client = new GreetClient();
        try {
            clientSocket = new Socket("localhost", 6666);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            if (text.equals("koniec")) {
                out.println(text);
                in.close();
                out.close();
                clientSocket.close();
//                c1.running = false;


            } else{
                String akutalnyCas = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
                String sprava = akutalnyCas + " | " + Pouzivatel + " : " + (text);
                out.println(sprava);
            }




        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
