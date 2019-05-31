package client.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class VyskakovacieOknoController {

    @FXML
    public Button TlacitkoOk;
    @FXML
    public Label TEXT;
    public static String TextNazobrazenie = "";

    @FXML
    public void initialize(){
        TEXT.setText(TextNazobrazenie);}

    //public void funkciaTlacitkoOK(){
//        Dorobit zatvorenie okna
//        Stage stage = (Stage) TlacitkoOk.getScene().getWindow();
//        stage.close();
   // }


}
