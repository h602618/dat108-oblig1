package Oppgave3;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class HamburgerBrett {
    private final BlockingQueue<Hamburger> hamburgere;
    private int burgerIndex = 1;

    public HamburgerBrett(int kapasitet) {
        this.hamburgere = new LinkedBlockingQueue<>(kapasitet);
    }

    public Hamburger add() throws InterruptedException {
        Hamburger burger = new Hamburger(burgerIndex++);
        hamburgere.put(burger);

        return burger;
    }

    public Hamburger remove() throws InterruptedException {
        return hamburgere.take();
    }

    @Override
    public String toString() {
        return Arrays.toString(hamburgere.toArray());
    }
}
