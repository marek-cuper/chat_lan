package client;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class nacitanieChatu {
    public static String nacitanieChatuFunkcia(){
        Vyberac vb = new Vyberac();
        String Chat = "";
        try {
            try (BufferedReader br = new BufferedReader(new FileReader("ClientHistoria"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if("Sprava".equals(vb.VyberacFunkcia("typ",line))){
                        Chat += (vb.VyberacFunkcia("meno",line) + ": " +vb.VyberacFunkcia("data",line)+ "\n");
                    }
                    if("Prihlasenie".equals(vb.VyberacFunkcia("typ",line))){
                        Chat += ("Uzivatel "+vb.VyberacFunkcia("meno",line) + " sa pirhlasil do chatu. Privitajte ho"+ "\n");
                    }
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    return Chat;
    }
}
