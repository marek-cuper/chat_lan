package client.controller;

import client.Okna.ChatovacieOkno;
import client.GlobalnePremenne;
import client.PosielacSpravy;
import javafx.scene.control.Button;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;



public class PrivitacieOknoController {



    @FXML
    public Button TlacitkoPokracovat;

    public TextField TextFieldMenoPouzivatela;



    @FXML
    public void PrivitacieOknoTlacitko(){

        GlobalnePremenne GP = new GlobalnePremenne();
        GP.MenoPouzivatela = TextFieldMenoPouzivatela.getText();
        TlacitkoPokracovat.setText("Otvorene");
        PosielacSpravy PS = new PosielacSpravy();
        PS.poslanieSpravy(GP.MenoPouzivatela, "sa pripojil ako novy pouzivatel!!! ");

        ChatovacieOkno ChO = new ChatovacieOkno();
        ChO.FunkciaChatovacieOkno();

        System.out.println(GP.MenoPouzivatela+" v privitacom okne");

    }



}

