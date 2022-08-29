package Oppgave2;

import java.util.Random;

public class Kokk extends Thread {
    private HamburgerBrett brett;
    private String navn;

    public Kokk(HamburgerBrett brett, String navn) {
        this.brett = brett;
        this.navn = navn;
    }

    @Override
    public void run() {
        Random rand = new Random();
        while (true) {
            brett.setIndeks(brett.getIndeks()+1);
            Hamburger hamburger = new Hamburger(brett.getIndeks());

            brett.leggTil(hamburger);

            try {
//                Thread.sleep((rand.nextInt(6 - 1) + 1) * 1000);
                Thread.sleep((rand.nextInt(6 - 1) + 1) * 100);
            } catch (InterruptedException e) {}
        }
    }

    @Override
    public void start() {
        run();
    }
}
