package Oppgave2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        final String[] kokker = {"Anne", "Erik", "Knut"};
        final String[] servitorer = {"Mia", "Per"};
        final int KAPASITET = 4;

        skrivUtHeader(kokker, servitorer, KAPASITET);

        HamburgerBrett brett = new HamburgerBrett(KAPASITET);


        int i = 0;
        for (String navn : kokker) {
            if(i++ > 1) continue;
            new Kokk(brett, navn).start();
        }

        for (String navn : servitorer) {
            new Servitor(brett, navn).start();
        }
    }

    private static void skrivUtHeader(String[] kokker, String[] servitorer, int kapasitet) {
        System.out.println("I denne simuleringen har vi");
        System.out.println(String.format("\t\t%d kokker %s", kokker.length, Arrays.toString(kokker)));
        System.out.println(String.format("\t\t%d servitører %s", servitorer.length, Arrays.toString(servitorer)));
        System.out.println(String.format("\t\tKapasiteten til brettet er %d hamburgere.", kapasitet));
        System.out.println("Vi starter ...");
    }
}
