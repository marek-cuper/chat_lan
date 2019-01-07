//package client;
//
//
//import java.io.File;
//import java.util.Scanner;
//
//
//
//
//public class Client {
//
//    static public boolean running = true;
//
//    public static void main(String[] args){
//
//    System.out.println("zaciatok");
//        //**************************************************************************************************************
//        //Zistujem ci je toto prve prihlasenie(Zisti to podla toho ci uz je vytvoreny subor nastavenia kde ma zapisane meno)
//        // ak ano tak sa ho opytam na meno a zapisem si ho do nastaveni ak si ho bude chciet zmenit neskor bude to musiet urobit manualne
//        Scanner sc = new Scanner(System.in);
//        File f = new File("client/nastavenia.pouzivatela");
//
//        if(!f.exists()){
//            System.out.println("Vitajte v aplikacii Chat Lan! Zadajte vase pouzivatelske meno ktorym budete prihlaseny do aplikacii: ");
//            String MenoPouzivatela = sc.nextLine();
//            client.NastavenieMenaPouzivateloviIpServera NMP = new client.NastavenieMenaPouzivateloviIpServera();
//            NMP.NastavenieMena(MenoPouzivatela);
//        }
//
//        client.VraciaHodnotyZNastaveni VMP = new client.VraciaHodnotyZNastaveni();
//        String MenoPouzivatela = VMP.VratiMenoPouzivatela();
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
//
//    }
//
//
//
//}
