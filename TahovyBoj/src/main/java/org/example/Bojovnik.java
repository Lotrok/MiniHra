package org.example;

public class Bojovnik {

    protected String jmeno;
    protected int zivot;
    protected int maximalnZivot;
    protected int utok;
    protected int obrana;
    protected Kostka kostka;
    private String zprava;

    protected void nastavZpravu(String zprava) {
        this.zprava = zprava;
    }

    public String vratPosledniZpravu(){
        return zprava;
    }

    public Bojovnik(String jmeno, int zivot, int utok, int obrana, Kostka kostka){
        this.jmeno = jmeno;
        this.zivot = zivot;
        this.maximalnZivot = zivot;
        this.utok = utok;
        this.obrana = obrana;
        this.kostka = kostka;
    }

    public boolean jeZivy() {
        return (zivot > 0);
    }

    public String grafickyZivot() {
        String grafickyZivot = "[";
        int celkem = 20;
        double pocetDilku = Math.round(((double) zivot / maximalnZivot) * celkem);
        if ((pocetDilku == 0) && (jeZivy())) {
            pocetDilku = 1;
        }
        for (int i = 0; i < pocetDilku; i++) {
            grafickyZivot += "#";
        }
        for (int i = 0; i < celkem - pocetDilku; i++) {
            grafickyZivot += " ";
        }
        grafickyZivot += "]";
        return grafickyZivot;
    }

    public void branSe(int uder) {
        int zraneni = uder - (obrana + kostka.hod());
        if (zraneni > 0) {
            zivot -= zraneni;
            zprava = String.format("%s utrpel poškození %s hp", jmeno, zraneni);
        if (zivot <= 0) {
            zivot = 0;
            zprava += " a zemřel";
           }
        } else {
            zprava = String.format("%s odrazil úrok", jmeno);
        }
    }

    public void utoc(Bojovnik souper) {
        int uder = utok + kostka.hod();
        nastavZpravu(String.format("%s utrpěl poškození %s hp", jmeno, uder));
        souper.branSe(uder);
    }




    @Override
    public String toString(){
        return jmeno;
    }



}
