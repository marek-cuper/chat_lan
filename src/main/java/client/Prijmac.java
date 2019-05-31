package client;

import client.Okna.VyskakovacieOkno;
import server.Server;

import java.io.*;


public class Prijmac extends  Thread{

    public void run(){

        Server S = new Server();
        try {

            PrijmaciKanal pk = new PrijmaciKanal();
            pk.otvoreniePrijmaciehoKanalu(6667);
            while(S.running) {


                String sprava = pk.getPrijmaciIn().readLine();
                System.out.println(sprava);
                if (sprava.equals("koniec")) {
                    pk.uzatvoreniePrijmaciehoKanalu();
                    S.running = false;
                }
                else if("Registracia:Zlyhala".equals(sprava)){
                    VyskakovacieOkno vo = new VyskakovacieOkno();
                    System.out.println("nezaregistrovany");
                    vo.FunkciaVyskakovacieOkno("Meno uz je zaregistrovane");
                }
                else if("Registracia:Prebehla".equals(sprava)){
                    VyskakovacieOkno vo = new VyskakovacieOkno();
                    System.out.println("zaregistrovany");
                    vo.FunkciaVyskakovacieOkno("Uspesne zaregistrovany");

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

