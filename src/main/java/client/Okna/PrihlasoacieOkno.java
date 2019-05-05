package client.Okna;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrihlasoacieOkno {

    public void FunkciaPrivitacieOkno(){


        System.out.println("Otvorenie prihlasovacie okna");


        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getClassLoader().getResource("PrihlasoacieOkno.fxml"));
            Parent root1 = (Parent)fxmloader.load();
            Stage stage = new Stage();
            stage.setTitle("Chat-Lan");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e){
            System.out.println("Neda sa nacitat nove okno");
            e.printStackTrace();
        }
    }

}
