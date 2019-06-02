package client.controller;

import client.Okna.ChatovacieOkno;
import client.GlobalnePremenne;
import client.Okna.RegistracneOkno;
import client.Posielace;
import client.PrenosovyKanal;
import javafx.scene.control.Button;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;



public class PrihlasovacieOknoController {



    @FXML
    public Button TlacitkoPokracovat;
    public TextField TextFieldMeno;
    public TextField TextFieldHeslo;



    @FXML
    public void prihlasovacieOknoTlacitko(){

        GlobalnePremenne GP = new GlobalnePremenne();
        GP.MenoPouzivatela = TextFieldMeno.getText();
        GP.HesloPouzivatela = TextFieldHeslo.getText();

        Posielace pos = new Posielace();
        pos.posielacPrihlasenia(TextFieldMeno.getText(),TextFieldHeslo.getText());




    }

    public void registracneOknoTlacitko(){

        RegistracneOkno ro = new RegistracneOkno();
        ro.FunkciaRegistracneOkno();

    }



}

