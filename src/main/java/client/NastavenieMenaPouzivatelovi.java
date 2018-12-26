package client;

import java.util.Properties;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class NastavenieMenaPouzivatelovi {

    public static void NastavenieMena(String Meno){
        Properties prop = new Properties();
        OutputStream output = null;

        try {

            output = new FileOutputStream("client/nastavenia.pouzivatela");

            // set the properties value
            prop.setProperty("Meno", Meno);


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
