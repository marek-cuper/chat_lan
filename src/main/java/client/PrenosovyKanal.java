package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;



class PrenosovyKanal {

    private Socket posielaciSocket;
    private PrintWriter posielaciOut;
    private BufferedReader posielaciIn;

    private String test1;
    static String test2 = "dovi";

    PrenosovyKanal() {
    }

    PrenosovyKanal(String str) {
        this.test1 = str;
    }

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    public static String getTest2() {
        return test2;
    }

    public static void setTest2(String test2) {
        PrenosovyKanal.test2 = test2;
    }

    void otvoreniePrenosovehoKanalu(String ip, int port){

        try{
            posielaciSocket = new Socket(ip, port);
            posielaciOut = new PrintWriter(posielaciSocket.getOutputStream(), true);
            posielaciIn = new BufferedReader(new InputStreamReader(posielaciSocket.getInputStream()));

        } catch (
            IOException e) {
            e.printStackTrace();

        }
    }


    void uzatvoreniePrenosovehoKanalu(){

        try{
            posielaciIn.close();
            posielaciOut.close();
            posielaciSocket.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }


    public PrintWriter getPosielaciOut() {
        return posielaciOut;
    }
}
