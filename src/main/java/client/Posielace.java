package client;

public class Posielace {


    public static void posielacSpravy(String Pouzivatel, String text) {




        PrenosovyKanal pk = new PrenosovyKanal();
        pk.otvoreniePrenosovehoKanalu("localhost", 6666);

        if (text.equals("koniec")) {
            pk.getPosielaciOut().println(text);
            pk.uzatvoreniePrenosovehoKanalu();

        } else {

            String sprava = System.currentTimeMillis() + "|" + "Sprava" + Pouzivatel + "|" + (text);
            pk.getPosielaciOut().println(sprava);
        }

    }


    public static void posielacPrihlasenia(String Meno, String Heslo) {

        PrenosovyKanal pk = new PrenosovyKanal();
        pk.otvoreniePrenosovehoKanalu("localhost", 6666);

        String sprava = System.currentTimeMillis() + "|" + "Prihlasenie" + "|" + Meno + "|" + Heslo.hashCode();

        pk.getPosielaciOut().println(sprava);

//        pk.uzatvoreniePrenosovehoKanalu();
//        PrenosovyKanal Test1 = new PrenosovyKanal("ahoj");
//        PrenosovyKanal Test2 = new PrenosovyKanal("nazdar");
//        System.out.println(Test1.getTest1());       // ahoj
//        System.out.println(Test1.getTest2());       // dovi
//        System.out.println(Test2.getTest1());       // nazdar
//        System.out.println(Test2.getTest2());       // dovi
//
//        Test1.setTest2("cau");
//        System.out.println(Test1.getTest2());       // cau
//        System.out.println(Test2.getTest2());       // dovi


    }

    public static void posielacRegistracie(String Meno, String Heslo) {

        PrenosovyKanal pk = new PrenosovyKanal();
        pk.otvoreniePrenosovehoKanalu("localhost", 6666);

        String sprava = System.currentTimeMillis() + "|" + "Registracia" + "|" + Meno + "|" + Heslo.hashCode();

        pk.getPosielaciOut().println(sprava);

        pk.uzatvoreniePrenosovehoKanalu();

    }

    public  static boolean jeHesloPouzitelne(String heslo){
        if (heslo.matches("[a-zA-Z0-9]*"))
            return true;
        else return false;

    }
}