package Oppgave2;

import java.util.Random;

public class Servitor extends Thread {
    private HamburgerBrett brett;
    private String navn;

    public Servitor(HamburgerBrett brett, String navn) {
        this.brett = brett;
        this.navn = navn;
    }

    @Override
    public void run() {
        Random rand = new Random();
        while (true) {
            try {
//            brett.setIndeks(brett.getIndeks()+1);
//            Hamburger hamburger = new Hamburger(brett.getIndeks());
//
//            brett.leggTil(hamburger);

//                Thread.sleep((rand.nextInt(6 - 1) + 1) * 1000);
//                Thread.sleep((rand.nextInt(6 - 1) + 1) * 100);
                if (brett.erTom()) {
                    wait();

                    Hamburger hamburger = brett.fjern();
                }
            } catch (InterruptedException e) {
            }
        }
    }

    @Override
    public void start() {
        run();
    }
}
