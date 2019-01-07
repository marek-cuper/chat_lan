package client;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class VraciaHodnotyZNastaveni {
    public static String VratiMenoPouzivatela(){

        Properties prop = new Properties();
        InputStream vstup = null;

        try {

            vstup = new FileInputStream("client/nastavenia.pouzivatela");

            // load a properties file
            prop.load(vstup);

            // get the property value and print it out
            return (prop.getProperty("Meno"));

        } catch (IOException ex) {
            ex.printStackTrace();
            return"Meno";
        } finally {
            if (vstup != null) {
                try {
                    vstup.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String VratiIpServera(){

        Properties prop = new Properties();
        InputStream vstup = null;

        try {

            vstup = new FileInputStream("client/nastavenia.pouzivatela");

            // load a properties file
            prop.load(vstup);

            // get the property value and print it out
            return (prop.getProperty("IpServera"));

        } catch (IOException ex) {
            ex.printStackTrace();
            return"IpServera";
        } finally {
            if (vstup != null) {
                try {
                    vstup.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    
}

