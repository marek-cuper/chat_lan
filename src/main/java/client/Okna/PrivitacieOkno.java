package client.Okna;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrivitacieOkno {

    public void FunkciaPrivitacieOkno(){


        System.out.println("Otvorenie privitacieho okna");


        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getClassLoader().getResource("privitacieOkno.fxml"));
            Parent root1 = (Parent)fxmloader.load();
            Stage stage = new Stage();
            stage.setTitle("Lan-Chat");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception ex){
            System.out.println("Neda sa nacitat nove okno");
        }




    }
}
