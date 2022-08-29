package Oppgave2;

import java.util.concurrent.ThreadLocalRandom;

public class Kokk extends Thread {
    private final HamburgerBrett brett;
    private final String navn;

    public Kokk(HamburgerBrett brett, String navn) {
        this.brett = brett;
        this.navn = navn;
    }

    private void lagBurger() {
        synchronized (brett) {
            while (brett.getHamburgere().size() == brett.getKapasitet()) {
                System.out.println(String.format("%s (kokk) klar med hamburger, men brett er fult. Venter!", navn));
                try {
                    brett.wait();
                } catch (InterruptedException e) {
                }
            }

            Hamburger burger = new Hamburger(brett.getBurgerIndex());
            brett.setBurgerIndex();
            brett.getHamburgere().add(burger);

            System.out.println(toString(burger));
            brett.notifyAll();
        }
    }

    public void run() {
        while (true) {
            lagBurger();

            try {
                Thread.sleep(ThreadLocalRandom.current().nextLong(2, 6) * 1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public String toString(Hamburger hamburger) {
        return String.format("%s (kokk) legger på hamburger %s. Brett: %s", navn, hamburger, brett.toString());
    }
}
