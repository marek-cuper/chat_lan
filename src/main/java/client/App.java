package client;

import client.Okna.PrivitacieOkno;

public class App extends  Thread{

    public void run(){

        PrivitacieOkno PrO = new PrivitacieOkno();
        PrO.FunkciaPrivitacieOkno();


        for(int i = 0;i<100;i++){
            System.out.println("App :"+i);

        }
    }

}

