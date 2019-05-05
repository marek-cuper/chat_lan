package client.controller;

import client.Okna.ChatovacieOkno;
import client.GlobalnePremenne;
import client.Okna.RegistracneOkno;
import client.Posielace;
import javafx.scene.control.Button;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;



public class PrihlasovacieOknoController {



    @FXML
    public Button TlacitkoPokracovat;
    public TextField TextFieldMeno;
    public TextField TextFieldHeslo;
    public TextArea ChatovaciaArea;



    @FXML
    public void prihlasovacieOknoTlacitko(){

        GlobalnePremenne GP = new GlobalnePremenne();
        GP.MenoPouzivatela = TextFieldMeno.getText();
        GP.HesloPouzivatela = TextFieldHeslo.getText();
        Posielace pos = new Posielace();
        pos.posielacPrihlasenia(GP.MenoPouzivatela,GP.HesloPouzivatela);
        TlacitkoPokracovat.setText("Otvorene");
        Posielace PS = new Posielace();
        //PS.posielacSpravy(GP.MenoPouzivatela, "sa pripojil ako novy pouzivatel!!! ");

        //ChatovacieOkno ChO = new ChatovacieOkno();
        //ChO.FunkciaChatovacieOkno();

    }

    public void registracneOknoTlacitko(){

        RegistracneOkno ro = new RegistracneOkno();
        ro.FunkciaRegistracneOkno();

    }



}

