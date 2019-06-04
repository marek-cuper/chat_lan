package client.controller;

import client.GlobalnePremenne;
import client.Posielace;
import client.nacitanieChatu;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import javax.swing.text.html.ImageView;
import java.util.concurrent.TimeUnit;


public class ChatovacieOknoController {

    @FXML
    public Button TlacitkoPoslatSpravu;



    @FXML
    public TextField Sprava;
    public CheckBox Obnovovac;
    public TextArea ChatovaciaArea;

    public void nacitatChat(){
        nacitanieChatu nc = new nacitanieChatu();
//        if(nc.nacitanieChatuFunkcia()==null){
//        }
        String text = nc.nacitanieChatuFunkcia();
         ChatovaciaArea.setText(text);

    }
    public void poslatSpravu(){

        Posielace ps = new Posielace();
        GlobalnePremenne GP = new GlobalnePremenne();
        ps.posielacSpravy(GP.MenoPouzivatela, Sprava.getText());
        Sprava.clear();
        nacitanieChatu nc = new nacitanieChatu();

        String text = nc.nacitanieChatuFunkcia();
        try {

            Thread.sleep(100);
            ChatovaciaArea.setText(text);

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }


    }



}
