package client.Okna;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenoHesloChyboveOkno {
    public void FunkciaMenoHesloChyboveOkno(){


        System.out.println("Otvorenie MenoHesloChyboveho okna");


        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getClassLoader().getResource("MenoHesloChyboveOkno.fxml"));
            Parent root1 = (Parent)fxmloader.load();
            Stage stage = new Stage();
            stage.setTitle("Chyba pri Prhlasovani alebo Registracii");
            stage.setScene(new Scene(root1,200,100));
            stage.show();
        } catch(Exception ex){
            System.out.println("Neda sa nacitat MenoHesloChyboveOkno");
        }




    }
}
