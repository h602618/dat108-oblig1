package Oppgave3;

import java.util.concurrent.ThreadLocalRandom;

public class Servitor extends Thread {
    private final HamburgerBrett brett;
    private final String navn;

    public Servitor(HamburgerBrett brett, String navn) {
        this.brett = brett;
        this.navn = navn;
    }

    public void fjernBurger() throws InterruptedException {
        skrivUt(brett.remove());
    }

    public void run() {
        while (true) {
            try {
                fjernBurger();
                Thread.sleep(ThreadLocalRandom.current().nextLong(2, 6) * 1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public void skrivUt(Hamburger hamburger) {
        System.out.println(String.format("%s (servitør) tar av hamburger %s. Brett: %s", navn, hamburger, brett));
    }
}
