package org.example;

class Mag extends Bojovnik {
    private int mana;
    private int maximalniMana;
    private int magickyUtok;

    public Mag(String jmeno, int zivot, int utok, int obrana, Kostka kostka, int mana, int magickyUtok) {
        super(jmeno, zivot, utok, obrana, kostka);
        this.mana = mana;
        this.maximalniMana = mana;
        this.magickyUtok = magickyUtok;
    }


    @Override
    public void utoc(Bojovnik souper) {
        // mana neni naplnena
        if (mana < maximalniMana) {
            mana += 10;
            if (mana > maximalniMana) {
                mana = maximalniMana;
            }
            super.utoc(souper);
        } else { //magicky utok

            int uder = magickyUtok + kostka.hod();
            nastavZpravu(String.format("%s použil magii za %s hp", jmeno, uder));
            souper.branSe(uder);
            mana = 0;
        }
    }
}



