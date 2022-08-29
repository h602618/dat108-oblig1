package Oppgave1;

import static javax.swing.JOptionPane.showInputDialog;

public class Main {
    public static void main(String[] args) {
        MyThread t = new MyThread("Hallo verden");
        t.start();

        while (t.isRunning()) {
            String melding = showInputDialog("Skriv inn din melding, quit for å slutte");
            if (melding.equals("quit")) {
                t.setRunning(false);
            } else {
                t.setMelding(melding);
            }
        }
    }
}