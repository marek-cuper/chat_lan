package client.controller;

import client.Okna.ChatovacieOkno;
import javafx.scene.control.Button;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class Controller {

    @FXML
    public Button button;

    public TextField MenoPouzivatela;


    @FXML
    public void stlaceneTlacitko(){
        button.setText("Otvorene");

        ChatovacieOkno ChO = new ChatovacieOkno();
        ChO.FunkciaChatovacieOkno();

    }

    public void zadaneMenoPouzivatela(){
      //  if (MenoPouzivatela.getCode){ }

    }

}

