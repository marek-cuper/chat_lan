package client.controller;

import client.GlobalnePremenne;
import client.Posielace;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;


public class ChatovacieOknoController {

    @FXML
    public Button TlacitkoPoslatSpravu;

    @FXML
    public TextField Sprava;

    public void PoslatSpravu(){


        Posielace ps = new Posielace();
        GlobalnePremenne GP = new GlobalnePremenne();
        ps.posielacSpravy(GP.MenoPouzivatela, Sprava.getText());
        System.out.println(GP.MenoPouzivatela+"v ChatovacomOknecontroller");
    }



}
