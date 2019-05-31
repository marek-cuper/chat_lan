package client.controller;

import client.GlobalnePremenne;
import client.Posielace;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
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

    public void nacitatChat(){



    }
    public void poslatSpravu(){


        Posielace ps = new Posielace();
        GlobalnePremenne GP = new GlobalnePremenne();
        ps.posielacSpravy(GP.MenoPouzivatela, Sprava.getText());

    }



}
