package client;

public class Posielace {

    public void posielacSpravy(String Pouzivatel, String text) {

        PrenosovyKanal pk = new PrenosovyKanal();
        Prijmac pr = new Prijmac();

        if (text.equals("koniec")) {
            pk.zasielac(text);
        } else {
            String sprava = System.currentTimeMillis() + "|" + "Sprava" + "|" + pr.port  +"|" + Pouzivatel + "|" + (text);

                    pk.zasielac(sprava);
                    System.out.println(sprava);
                }
    }

    public void posielacPrihlasenia(String Meno, String Heslo) {

        PrenosovyKanal pk = new PrenosovyKanal();
        Prijmac pr = new Prijmac();

        String sprava = System.currentTimeMillis() + "|" + "Prihlasenie" + "|" + pr.port +"|" + Meno + "|" + Heslo.hashCode();

        pk.zasielac(sprava);
        System.out.println(sprava);
    }

    public void posielacRegistracie(String Meno, String Heslo) {

        PrenosovyKanal pk = new PrenosovyKanal();
        Prijmac pr = new Prijmac();

        String sprava = System.currentTimeMillis() + "|" + "Registracia" + "|" + pr.port + "|" + Meno + "|" + Heslo.hashCode();

        pk.zasielac(sprava);
        System.out.println(sprava);
    }

    public boolean jeHesloPouzitelne(String heslo){
        if (heslo.matches("[a-zA-Z0-9]*"))
            return true;
        else return false;

    }
}