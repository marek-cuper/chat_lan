package client.controller;

import client.Okna.VyskakovacieOkno;
import client.Posielace;
import client.PrenosovyKanal;
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
        PrenosovyKanal pk = new PrenosovyKanal();
        Posielace pos = new Posielace();

        if(pos.jeHesloPouzitelne(TextFieldMeno.getText()) && pos.jeHesloPouzitelne(TextFieldHeslo.getText())&&!TextFieldMeno.getText().isEmpty()&&!TextFieldHeslo.getText().isEmpty()){

            pos.posielacRegistracie(TextFieldMeno.getText(),TextFieldHeslo.getText());
            System.out.println("Poslana registracia");}
        else{
            VyskakovacieOkno nhco = new VyskakovacieOkno();
            nhco.FunkciaVyskakovacieOkno("Heslo moze obsahovat len cisla a pismena");
        }
    }

}
