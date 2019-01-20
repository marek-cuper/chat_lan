package client;

import client.Okna.PrivitacieOkno;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;


public class Main extends Application {





    @Override
    public void start(Stage primaryStage) throws Exception{


        Prijmac PrijmacIde = new Prijmac();
        PrijmacIde.start();

        App AppIde = new App();
        AppIde.start();


//        File f = new File("client/nastavenia.pouzivatela");
//        if(!f.exists()){
//            PrivitacieOkno PrO = new PrivitacieOkno();
//            PrO.FunkciaPrivitacieOkno();
//
//
////            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("privitacieOkno.fxml"));
////            primaryStage.setTitle("Lan-Chat");
////            primaryStage.setScene(new Scene(root, 635, 502));
////            primaryStage.show();
//        }
//        else{
//            ChatovacieOkno ChO = new ChatovacieOkno();
//            ChO.FunkciaChatovacieOkno();
//        }



    }


    public static void main(String[] args) {
        launch(args);
        Platform.exit();
    }


    }


