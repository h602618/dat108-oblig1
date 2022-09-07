package Oppgave3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class HamburgerBrett {
    private final int kapasitet;
    private final Queue<Hamburger> hamburgere = new LinkedList<>();
    private int burgerIndex = 1;

    public HamburgerBrett(int kapasitet) {
        this.kapasitet = kapasitet;
    }

    public int getKapasitet() {
        return kapasitet;
    }

    public Queue<Hamburger> getHamburgere() {
        return hamburgere;
    }

    public int getBurgerIndex() {
        return burgerIndex;
    }

    public void setBurgerIndex() {
        burgerIndex++;
    }

    @Override
    public String toString() {
        return Arrays.toString(hamburgere.toArray());
    }
}
