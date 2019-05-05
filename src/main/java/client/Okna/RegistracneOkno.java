package client.Okna;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegistracneOkno {

    public void FunkciaRegistracneOkno(){


        System.out.println("Otvorenie registracneho okna");


        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getClassLoader().getResource("RegistracneOkno.fxml"));
            Parent root1 = (Parent)fxmloader.load();
            Stage stage = new Stage();
            stage.setTitle("Registracia");
            stage.setScene(new Scene(root1,250,300));
            stage.show();
        } catch(Exception ex){
            System.out.println("Neda sa nacitat RegistracneOkno");
        }




    }
}