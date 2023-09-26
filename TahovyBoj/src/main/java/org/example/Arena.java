package org.example;
import java.util.Scanner;

class Arena {
    private Bojovnik bojovnikA;
    private Bojovnik bojovnikB;
    private Kostka kostka;

    public Arena(Bojovnik bojovnikA, Bojovnik bojovnikB, Kostka kostka) {
        this.bojovnikA = bojovnikA;
        this.bojovnikB = bojovnikB;
        this.kostka = kostka;
    }

    private void vykresli() {
        System.out.println("-------------- Aréna -------------- \n");
        System.out.println("Zdraví bojovníků: \n");
        System.out.printf("%s %s%n", bojovnikA, bojovnikA.grafickyZivot());
        System.out.printf("%s %s%n", bojovnikB, bojovnikB.grafickyZivot());
    }

    private void vypisZpravu(String zprava) {
        System.out.println(zprava);
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.err.println("Chyba, nepodařilo se uspat vlákno!");
        }
    }

    public void zapas() {
        System.out.println("Vítejte v aréně!");
        System.out.printf("Dnes se utkají %s s %s! %n", bojovnikA, bojovnikB);
        System.out.println("Zápas může začít...");

        // cyklus s bojem
        while (bojovnikA.jeZivy() && bojovnikB.jeZivy()) {
            bojovnikA.utoc(bojovnikB);
            vykresli();
            vypisZpravu(bojovnikA.vratPosledniZpravu()); // zpráva o útoku
            vypisZpravu(bojovnikB.vratPosledniZpravu()); // zpráva o obraně
            bojovnikB.utoc(bojovnikA);
            vykresli();
            vypisZpravu(bojovnikB.vratPosledniZpravu()); // zpráva o útoku
            vypisZpravu(bojovnikA.vratPosledniZpravu()); // zpráva o obraně
            System.out.println();
        }
    }
}
