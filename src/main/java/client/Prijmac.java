package client;

import client.Okna.ChatovacieOkno;
import client.Okna.VyskakovacieOkno;
import client.controller.ChatovacieOknoController;
import server.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Prijmac extends  Thread{

    PracaSPortom psp = new PracaSPortom();
    public static int port = PracaSPortom.nastavPortKlienta();

    public void run(){


        ServerSocket serverSocket;
        Socket clientSocket;
        PrintWriter out;
        BufferedReader in;
        Server S = new Server();



        try {

            serverSocket = new ServerSocket(port);


            while(S.running) {

                clientSocket = serverSocket.accept();
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String sprava = in.readLine();
                System.out.println(sprava);
                nacitanieChatu nc = new nacitanieChatu();

                VyskakovacieOkno vo = new VyskakovacieOkno();
                if ("koniec".equals(sprava)) {
                    S.running = false;
                }
                else if("Registracia:Zlyhala".equals(sprava)){
                    System.out.println("nezaregistrovany");
                    vo.FunkciaVyskakovacieOkno("Meno uz je zaregistrovane");
                }
                else if("Registracia:Prebehla".equals(sprava)){
                    System.out.println("zaregistrovany");
                    vo.FunkciaVyskakovacieOkno("Ste uspesne zaregistrovany");
                }
                else if("Prihlasenie:Prebehlo".equals(sprava)){
                    System.out.println("Prihlaseny");
                    ChatovacieOkno ChO = new ChatovacieOkno();
                    ChO.FunkciaChatovacieOkno();


                }
                else if("Prihlasenie:Zlyhalo".equals(sprava)){
                    System.out.println("zaregistrovany");
                    vo.FunkciaVyskakovacieOkno("Meno alebo heslo ste zadali nespravne");
                }
                else{
                    System.out.println(sprava);
                    sprava = sprava + "\n";
                    FileOutputStream fos = new FileOutputStream("ClientHistoria", true);
                    fos.write(sprava.getBytes());
                    fos.close();

                }
                ChatovacieOknoController coc = new ChatovacieOknoController();

                File chistoria = new File("ClientHistoria");

                System.out.println(nc.nacitanieChatuFunkcia());
                if(chistoria.length()==0){}
                //else  coc.nacitatChat();


            }
        } catch (IOException e) {
            e.printStackTrace();
            // TODO: add logging

        }
    }


}

