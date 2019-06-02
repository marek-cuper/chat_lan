package client.Okna;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChatovacieOkno {

    public void FunkciaChatovacieOkno(){


        System.out.println("Otvorenie chatovacieho okna");

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader fxmloader = new FXMLLoader(getClass().getClassLoader().getResource("chatovacieOkno.fxml"));
                    Parent root1 = (Parent)fxmloader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Chat-Lan Chatovacie okno");
                    stage.setScene(new Scene(root1));
                    stage.show();
                } catch(Exception e){
                    System.out.println("Neda sa nacitat nove okno");
                    e.printStackTrace();
                }
            }
        });
    }
}
