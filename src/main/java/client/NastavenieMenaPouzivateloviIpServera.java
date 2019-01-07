package client;

import java.util.Properties;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class NastavenieMenaPouzivateloviIpServera {

    public static void NastavenieMena(String Meno, String IpServera){
        Properties prop = new Properties();
        OutputStream output = null;

        try {

            output = new FileOutputStream("client/nastavenia.pouzivatela");

            // set the properties value
            prop.setProperty("Meno", Meno);
            prop.setProperty("IpServera", IpServera);


            // save properties to project root folder
            prop.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
}}
