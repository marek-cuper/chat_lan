package client.Okna;

import client.controller.VyskakovacieOknoController;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VyskakovacieOkno {


    public void FunkciaVyskakovacieOkno(String Text){


        System.out.println("Otvorenie Vykakovacieho okna");

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    VyskakovacieOknoController voc = new VyskakovacieOknoController();
                    voc.TextNazobrazenie = Text;

                    FXMLLoader fxmloader = new FXMLLoader(getClass().getClassLoader().getResource("VyskakovacieOkno.fxml"));
                    Parent root1 = (Parent)fxmloader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Chyba pri Prhlasovani alebo Registracii");
                    stage.setScene(new Scene(root1, 400, 80));
                    stage.show();
                } catch(Exception ex){
                    System.out.println("Neda sa nacitat VyskakovacieOkno");
                    ex.printStackTrace();
                }
            }
        });





    }
}
