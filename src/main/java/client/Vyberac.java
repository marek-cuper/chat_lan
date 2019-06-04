package client;

import java.util.HashMap;
import java.util.Map;

public class Vyberac {
    private static String[] formatPrihReg = {"cas","typ","port","meno","heslo"};
    private static String[] formatSprav = {"cas","typ","port","meno","data"};


    public String VyberacFunkcia(String Udaj, String Sprava) {

        String[] castiSpravPole = Sprava.split("\\|");
        Map<String, String> castiSpravMap = new HashMap<String, String>();

        //castiSpravMap.put("cas", UpravaCasuNaCitatelny(castiSpravPole[0]));
        if (castiSpravPole.length==5){
            for(int i=0;i<=4;i++){
                if("Sprava".equals(castiSpravPole[1])){
                    castiSpravMap.put(formatSprav[i], castiSpravPole[i]);
                }else{
                    castiSpravMap.put(formatPrihReg[i], castiSpravPole[i]);
                }
            }
            return castiSpravMap.get(Udaj);
        }
        System.out.println("Vyberac funkcia chyba");
        return ("chyba");
    }
}
