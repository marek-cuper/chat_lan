package client.controller;

import client.Okna.MenoHesloChyboveOkno;
import client.Posielace;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class RegistracneOknoController {


    @FXML
    public Button TlacitkoRegistrovat;
    public TextField TextFieldMeno;
    public TextField TextFieldHeslo;


    @FXML
    public void funkciaRegistrovat(){
        Posielace pos = new Posielace();
        if(pos.jeHesloPouzitelne(TextFieldMeno.getText()) && pos.jeHesloPouzitelne(TextFieldHeslo.getText()))
            pos.posielacRegistracie(TextFieldMeno.getText(),TextFieldHeslo.getText());
        else{
            //MenoHesloChyboveOkno nhco = new MenoHesloChyboveOkno();
            //nhco.FunkciaMenoHesloChyboveOkno();
        }
    }

}
