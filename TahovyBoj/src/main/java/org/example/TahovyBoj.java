package org.example;

import java.security.spec.RSAOtherPrimeInfo;

public class TahovyBoj {
    public static void main(String[] args) {

        Kostka kostka = new Kostka(10);
        Bojovnik zalgoren = new Bojovnik("Darius", 90,17,16, kostka);
        Bojovnik shadow = new Bojovnik("Zed", 80, 18,15, kostka);
        Arena arena = new Arena(zalgoren, shadow, kostka);

        arena.zapas();


    }
}
