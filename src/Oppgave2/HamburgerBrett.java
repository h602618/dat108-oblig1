package Oppgave2;

import java.util.LinkedList;
import java.util.Queue;

public class HamburgerBrett {
    private int kapasitet;
    private int antall;
    private int indeks;
    private Queue<Hamburger> hamburgere;

    public HamburgerBrett(int kapasitet) {
        this.kapasitet = kapasitet+1;
        this.antall = 0;
        this.indeks = 0;
        this.hamburgere = new LinkedList<Hamburger>();
    }

    public boolean erTom() {
        return hamburgere.isEmpty();
    }

    public boolean erFull() {
        return hamburgere.size() == kapasitet;
    }

    public Hamburger leggTil(Hamburger hamburger) {
        if (!erFull()) {
            hamburgere.add(hamburger);

            System.out.println(hamburger);

            return hamburger;
        }

        return null;
    }

    public Hamburger fjern() {
        if (!erTom()) {
            return hamburgere.remove();
        }

        return null;
    }

    public int getIndeks() {
        return indeks;
    }

    public void setIndeks(int indeks) {
        this.indeks = indeks;
    }
}
