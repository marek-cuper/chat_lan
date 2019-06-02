package client;

public class Posielace {

    public void posielacSpravy(String Pouzivatel, String text) {

        PrenosovyKanal pk = new PrenosovyKanal();

        if (text.equals("koniec")) {
            pk.zasielac(text);
        } else {
            String sprava = System.currentTimeMillis() + "|" + "Sprava" + "|" + Pouzivatel + "|" + (text);

                    pk.zasielac(sprava);
                    System.out.println(sprava);
                }
    }

    public void posielacPrihlasenia(String Meno, String Heslo) {

        PrenosovyKanal pk = new PrenosovyKanal();

        String sprava = System.currentTimeMillis() + "|" + "Prihlasenie" + "|" + Meno + "|" + Heslo.hashCode();

        pk.zasielac(sprava);
        System.out.println(sprava);
    }

    public void posielacRegistracie(String Meno, String Heslo) {

        PrenosovyKanal pk = new PrenosovyKanal();

        String sprava = System.currentTimeMillis() + "|" + "Registracia" + "|" + Meno + "|" + Heslo.hashCode();

        pk.zasielac(sprava);
        System.out.println(sprava);
    }

    public boolean jeHesloPouzitelne(String heslo){
        if (heslo.matches("[a-zA-Z0-9]*"))
            return true;
        else return false;

    }
}