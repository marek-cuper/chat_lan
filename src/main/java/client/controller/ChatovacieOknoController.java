package client.controller;

import client.GlobalnePremenne;
import client.PosielacSpravy;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;


public class ChatovacieOknoController {

    @FXML
    public Button TlacitkoPoslatSpravu;

    public TextField Sprava;

    @FXML

    public void PoslatSpravu(){
        PosielacSpravy PS = new PosielacSpravy();
        GlobalnePremenne GP = new GlobalnePremenne();
        PS.poslanieSpravy(GP.MenoPouzivatela, Sprava.getText());
        System.out.println(GP.MenoPouzivatela+"v ChatovacomOknecontroller");
    }



}
