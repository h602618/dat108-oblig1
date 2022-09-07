package Oppgave3;

public class Hamburger {
    private final int id;

    public Hamburger(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("◖%d◗", id);
    }
}
