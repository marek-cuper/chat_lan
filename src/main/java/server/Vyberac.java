package server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


class Vyberac {

    private static String[] formatPrihReg = {"cas","typ","meno","heslo"};
    private static String[] formatSprav = {"cas","typ","meno","data"};

//    private String Sprava;
//    public VyberacFunkcia(String Sprava) {
//        this.Sprava = Sprava;
//    }
    public String VyberacFunkcia(String Udaj, String Sprava) {

        String[] castiSpravPole = Sprava.split("\\|");
        Map<String, String> castiSpravMap = new HashMap<String, String>();

        //castiSpravMap.put("cas", UpravaCasuNaCitatelny(castiSpravPole[0]));

        //Netusim co s tym je do Bytce
        //Netusim co s tym je do Bytce
        //Netusim co s tym je do Bytce
        //Netusim co s tym je do Bytce
        //Chyba pri registracii  java.lang.ArrayIndexOutOfBoundsException:
        for(int i=0;i<=3;i++){
            if("Sprava".equals(castiSpravPole[1])){
                castiSpravMap.put(formatSprav[i], castiSpravPole[i]);
            }else{
                castiSpravMap.put(formatPrihReg[i], castiSpravPole[i]);
            }
        }
        return castiSpravMap.get(Udaj);
    }

    public boolean kontrolerRegistracie(String Meno)throws Exception{
        try {
            try (BufferedReader br = new BufferedReader(new FileReader("Registrovane"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (VyberacFunkcia("meno",line).equals(Meno)){
                        return true;
                    }
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }






    public static String UpravaCasuNaCitatelny(String unixCas){
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//        return simpleDateFormat.format(new Date(Long.valueOf(unixCas)));
        return unixCas;
    }
}
