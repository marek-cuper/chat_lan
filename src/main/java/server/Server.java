package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


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


                    if (Sprava.equals("koniec")) {
                        in.close();
                        out.close();
                        clientSocket.close();
                        serverSocket.close();
                        S.running = false;

                    }
                    else if ("Registracia".equals(vb.VyberacFunkcia("typ", Sprava))) {
                        System.out.println(vb.VyberacFunkcia("meno",Sprava));
                        try {
                            if (vb.kontrolerRegistracie(vb.VyberacFunkcia("meno",Sprava))){
                                System.out.println("Zlyhanie");
                                ps.poslanieSpravy("Registracia:Zlyhala");
                            }
                            else{
                                ps.poslanieSpravy("Registracia:Prebehla");
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

                        //DOROBIT KONTROLU PRIHLASENIA
                    }

//                    VyberacFunkcia VZP = new VyberacFunkcia();
//                    System.posielaciOut.println(VZP.VyberacFunkcia("cas", Sprava));
//                    System.posielaciOut.println(VZP.VyberacFunkcia("typ", Sprava));
//                    System.posielaciOut.println(VZP.VyberacFunkcia("meno", Sprava));
//                    System.posielaciOut.println(VZP.VyberacFunkcia("heslo", Sprava));

                    else {
                        System.out.println(Sprava);

                        ps.poslanieSpravy(Sprava);
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









