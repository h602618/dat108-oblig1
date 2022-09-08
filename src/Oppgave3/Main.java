package Oppgave3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final String[] kokker = {"Anne", "Erik", "Knut"};
        final String[] servitorer = {"Mia", "Per"};
        final int KAPASITET = 4;
        skrivUtHeader(kokker, servitorer, KAPASITET);
        HamburgerBrett brett = new HamburgerBrett(KAPASITET);

        for (String navn : kokker) {
            new Kokk(brett, navn).start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }

        for (String navn : servitorer) {
            new Servitor(brett, navn).start();
        }
    }

    public static void skrivUtHeader(String[] kokker, String[] servitorer, int KAPASITET) {
        System.out.println("I denne simuleringen har vi");
        System.out.println(String.format("\t\t%d kokker %s", kokker.length, Arrays.toString(kokker)));
        System.out.println(String.format("\t\t%d servitører %s", servitorer.length, Arrays.toString(servitorer)));
        System.out.println(String.format("\t\tKapasiteten til brettet er %d hamburgere.", KAPASITET));
        System.out.println("Vi starter ...\n");
    }
}
