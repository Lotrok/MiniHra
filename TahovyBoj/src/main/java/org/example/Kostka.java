package org.example;
import java.util.Random;

public class Kostka {

    private Random random;
    private int pocetSten;

    public Kostka() {
        pocetSten = 6;
        random = new Random();
    }

    public Kostka(int pocetSten) {
        this.pocetSten = pocetSten;
        random = new Random();
    }

    public int vratPocetSten() {
        return pocetSten;
    }

    public int hod() {
        return random.nextInt(pocetSten) + 1;
    }


    @Override
    public String toString() {
        return String.format("Kostka s %s stěnami", pocetSten);
    }
}