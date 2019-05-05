package client;

import server.Server;

import java.io.*;


public class Prijmac extends  Thread{

    public void run(){

        Server S = new Server();
        try {


            while(S.running) {
                PrijmaciKanal pk = new PrijmaciKanal();
                pk.otvoreniePrijmaciehoKanalu(6667);

                String sprava = pk.getPrijmaciIn().readLine();

                if (sprava.equals("koniec")) {
                    pk.uzatvoreniePrijmaciehoKanalu();
                    S.running = false;

                } else{
                    System.out.println(sprava);
                    sprava = sprava + "\n";
                    FileOutputStream fos = new FileOutputStream("ClientHistoria", true);
                    fos.write(sprava.getBytes());
                    fos.close();

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
            // TODO: add logging

        }
    }


}

