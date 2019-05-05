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

                    VyberacZPosielaca vzp = new VyberacZPosielaca();

                    if(vzp.Vyberac("typ", Sprava).equals("Registracia")){

                        FileOutputStream fos = new FileOutputStream("Registrovane", true);
                        String Registracia = ("\n" + vzp.Vyberac("cas",Sprava)+"|" + "0" + "|" + vzp.Vyberac("meno",Sprava) + "|" + vzp.Vyberac("heslo",Sprava) );
                        fos.write(Registracia.getBytes());
                        fos.close();

                    }

//                    VyberacZPosielaca VZP = new VyberacZPosielaca();
//                    System.posielaciOut.println(VZP.Vyberac("cas", Sprava));
//                    System.posielaciOut.println(VZP.Vyberac("typ", Sprava));
//                    System.posielaciOut.println(VZP.Vyberac("meno", Sprava));
//                    System.posielaciOut.println(VZP.Vyberac("heslo", Sprava));








                    if (Sprava.equals("koniec")) {
                        in.close();
                        out.close();
                        clientSocket.close();
                        serverSocket.close();
                        S.running = false;

                    } else{
                        System.out.println(Sprava);

//                        PosielacSpravy PS = new PosielacSpravy();
//                        PS.poslanieSpravy(Sprava);
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









