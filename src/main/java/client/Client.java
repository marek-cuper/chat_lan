package client;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.util.Scanner;


public class Client extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui.fxml"));
        primaryStage.setTitle("UDP chat");
        primaryStage.setScene(new Scene(root, 635, 502));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        Platform.exit();
    }
}


//public class Client {
//    static public boolean running = true;

//    public static void main(String[] args) {
//
//        //**************************************************************************************************************
//        //Zistujem ci je toto prve prihlasenie(Zisti to podla toho ci uz je vytvoreny subor nastavenia kde ma zapisane meno)
//        // ak ano tak sa ho opytam na meno a zapisem si ho do nastaveni ak si ho bude chciet zmenit neskor bude to musiet urobit manualne
//        Scanner sc = new Scanner(System.in);
//        File f = new File("client/nastavenia.pouzivatela");
//
//        if(!f.exists()){
//            System.out.println("Vitajte v aplikacii Chat Lan! Zadajte vase pouzivatelske meno ktorym budete prihlaseny do aplikacii: ");
//            String MenoPouzivatela = sc.nextLine();
//            client.NastavenieMenaPouzivatelovi NMP = new client.NastavenieMenaPouzivatelovi();
//            NMP.NastavenieMena(MenoPouzivatela);
//        }
//
//        client.VypiseMenoPouzivatela VMP = new client.VypiseMenoPouzivatela();
//        String MenoPouzivatela = VMP.VratiMeno();
//        //**************************************************************************************************************
//
//
//        client.PosielacSpravy ps = new client.PosielacSpravy();
//
//        while (running) {
//            System.out.println("napis spravu ktoru chces poslat na server: ");
//
//            String Text = sc.nextLine();
//
//            ps.poslanieSpravy(MenoPouzivatela, Text);
//        }
//    }



//}
