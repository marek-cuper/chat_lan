package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Server  {
    static public boolean running = true;


         public static void main(String args[]){

          PrijmacNaServeri PrijmacIde = new PrijmacNaServeri();
          PrijmacIde.start();

          OdosielacNaServeri OdosielacIde = new OdosielacNaServeri();
          OdosielacIde.start();

        }
    }


    class OdosielacNaServeri extends  Thread{

        public void run(){

        }

}
    class PrijmacNaServeri extends Thread {

        List<Integer> portyKlientov = new ArrayList<Integer>();
       // private static int[] portyKlientov = {};
        int poslednyPortKlienta;

        public void run(){
            ServerSocket serverSocket;
            Socket clientSocket;
            PrintWriter out;
            BufferedReader in;
            Server S = new Server();


            try {
                serverSocket = new ServerSocket(6666);


                while(S.running) {

                    clientSocket = serverSocket.accept();
                    out = new PrintWriter(clientSocket.getOutputStream(), true);
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                    String Sprava = in.readLine();
                    System.out.println(Sprava);

                    Vyberac vb = new Vyberac();
                    PosielacSpravy ps = new PosielacSpravy();
                    PracaSPortmi psp = new PracaSPortmi();
                    poslednyPortKlienta = Integer.parseInt(vb.VyberacFunkcia("port",Sprava));


                    if(!psp.nachadzaSaPortVZozname(poslednyPortKlienta,portyKlientov)){
                            portyKlientov.add(poslednyPortKlienta);}

                    if (Sprava.equals("koniec")) {
                        in.close();
                        out.close();
                        clientSocket.close();
                        serverSocket.close();
                        S.running = false;

                    }
                    else if ("Registracia".equals(vb.VyberacFunkcia("typ", Sprava))) {
                        try {
                            if (vb.kontrolerRegistracie(vb.VyberacFunkcia("meno",Sprava))){
                                System.out.println("Zlyhanie reg");
                                for(int i=0;i<portyKlientov.size();i++){
                                    System.out.println(portyKlientov.get(i)+"dd");
                                    ps.poslanieSpravy("Registracia:Zlyhala",portyKlientov.get(i));
                                }

                            }
                            else{

                                for(int i=0;i<portyKlientov.size();i++){
                                    System.out.println(portyKlientov.get(i)+"dd");
                                    ps.poslanieSpravy("Registracia:Prebehla",portyKlientov.get(i));

                                }
                                System.out.println("Prebehla reg ");
                                FileOutputStream fos = new FileOutputStream("Registrovane", true);
                                Sprava = Sprava + "\n";
                                fos.write(Sprava.getBytes());
                                fos.close();
                            }
                        }catch (Exception ex){
                            ex.printStackTrace();
                        }
                    }
                    else if ("Prihlasenie".equals(vb.VyberacFunkcia("typ", Sprava))) {
                        try {
                            if (!vb.kontrolerPrihlasenia(vb.VyberacFunkcia("meno",Sprava),vb.VyberacFunkcia("heslo",Sprava))){
                                System.out.println("Zlyhalo prih");
                                for(int i=0;i<portyKlientov.size();i++){
                                    ps.poslanieSpravy("Prihlasenie:Zlyhalo",portyKlientov.get(i));
                                }

                            }
                            else {
                                for(int i=0;i<portyKlientov.size();i++){
                                    ps.poslanieSpravy("Prihlasenie:Prebehlo",portyKlientov.get(i));
                                }

                                System.out.println("Prebehlo prih");
                            }
                        }catch (Exception ex){
                            ex.printStackTrace();
                        }

                    }

                    else {
                        System.out.println(Sprava);

                        ps.poslanieSpravy(Sprava,poslednyPortKlienta);
                        Sprava = Sprava + "\n";
                        FileOutputStream fos = new FileOutputStream("ServerovaHistoria", true);
                        fos.write(Sprava.getBytes());
                        fos.close();
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
                // TODO: add logging

            }
        }}









