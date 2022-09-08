package Oppgave3;

import java.util.concurrent.ThreadLocalRandom;

public class Kokk extends Thread {
    private final HamburgerBrett brett;
    private final String navn;

    public Kokk(HamburgerBrett brett, String navn) {
        this.brett = brett;
        this.navn = navn;
    }

    private void lagBurger() throws InterruptedException {
        skrivUt(brett.add());
    }

    public void run() {
        while (true) {
            try {
                lagBurger();
                Thread.sleep(ThreadLocalRandom.current().nextLong(2, 6) * 1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public void skrivUt(Hamburger hamburger) {
        System.out.println(String.format("%s (kokk) legger på hamburger %s. Brett: %s", navn, hamburger, brett.toString()));
    }
}
