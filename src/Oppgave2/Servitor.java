package Oppgave2;

import java.util.concurrent.ThreadLocalRandom;

public class Servitor extends Thread {
    private final HamburgerBrett brett;
    private final String navn;

    public Servitor(HamburgerBrett brett, String navn) {
        this.brett = brett;
        this.navn = navn;
    }

    public void fjernBurger() {
        synchronized (brett) {
            while (brett.getHamburgere().size() == 0) {
                System.out.println(String.format("%s (servitør) ønsker å ta hamburger, men brett tomt. Venter!", navn));
                try {
                    brett.wait();
                } catch (InterruptedException e) {
                }
            }

            Hamburger burger = brett.getHamburgere().remove();

            System.out.println(toString(burger));
            brett.notifyAll();
        }
    }

    public void run() {
        while (true) {
            fjernBurger();

            try {
                Thread.sleep(ThreadLocalRandom.current().nextLong(2, 6) * 1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public String toString(Hamburger hamburger) {
        return String.format("%s (servitør) tar av hamburger %s. Brett: %s", navn, hamburger, brett.toString());
    }
}
