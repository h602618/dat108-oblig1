package Oppgave1;

public class MyThread extends Thread {
    public void setMelding(String melding) {
        this.melding = melding;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    private String melding;
    private boolean running;

    public MyThread(String melding) {
        this.melding = melding;
        this.running = true;
    }

    @Override
    public void run() {
        while (running) {
            System.out.println(melding);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
        }
    }
}
