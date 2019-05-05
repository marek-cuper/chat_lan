package server;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


class VyberacZPosielaca {

    private static String[] formatPrihReg = {"cas","typ","meno","heslo"};
    private static String[] formatSprav = {"cas","typ","meno","data"};



//    private String Sprava;
//    public VyberacZPosielaca(String Sprava) {
//        this.Sprava = Sprava;
//    }

    public String Vyberac(String Udaj,String Sprava) {

        String[] castiSpravPole = Sprava.split("\\|");
        Map<String, String> castiSpravMap = new HashMap<String, String>();
        
        castiSpravMap.put("cas", UpravaCasuNaCitatelny(castiSpravPole[0]));
        for(int i=1;i<=3;i++){
            if(castiSpravPole[1].equals("Sprava")){
                castiSpravMap.put(formatSprav[i], castiSpravPole[i]);
            }else{
                castiSpravMap.put(formatPrihReg[i], castiSpravPole[i]);
            }
        }
        return castiSpravMap.get(Udaj);

//        //System.posielaciOut.println(castiSpravMap.get("cas"));
//
//        if (castiSpravPole[1].equals("Prihlasenie")) {
//            if (Udaj.equals("meno")) {
//                return castiSpravPole[2];
//            }
//            if (Udaj.equals("heslo")) {
//                return castiSpravPole[3];
//            }
//            if (Udaj.equals("vsetko")) {
//                return (UpravaCasuNaCitatelny(castiSpravPole[0]) + castiSpravPole[1] + castiSpravPole[2] + castiSpravPole[3]);
//            }
//        }
//
//        else if (castiSpravPole[1].equals("Sprava")) {
//            if (Udaj.equals("meno")) {
//                return castiSpravPole[2];
//            }
//            if (Udaj.equals("sprava")) {
//                return castiSpravPole[3];
//            }
//            if (Udaj.equals("vsetko")) {
//                return (UpravaCasuNaCitatelny(castiSpravPole[0]) + castiSpravPole[1] + castiSpravPole[2] + castiSpravPole[3]);
//            }
//        }
//
//        System.posielaciOut.println("co mi to davas clovece?");
//        return ("chyba");
//

    }


    public static String UpravaCasuNaCitatelny(String unixCas){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return simpleDateFormat.format(new Date(Long.valueOf(unixCas)));
    }
}
