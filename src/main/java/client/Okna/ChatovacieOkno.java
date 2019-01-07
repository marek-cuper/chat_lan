package client.Okna;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChatovacieOkno {

    public void FunkciaChatovacieOkno(){

        System.out.println("Otvorenie chatovacieho okna");

        try {
            FXMLLoader fxmloader = new FXMLLoader(getClass().getClassLoader().getResource("chatovacieOkno.fxml"));
            Parent root1 = (Parent)fxmloader.load();
            Stage stage = new Stage();
            stage.setTitle("Lan-Chat Chatovacie okno");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception ex){
            System.out.println("Neda sa nacitat nove okno");
        }

    }
}
