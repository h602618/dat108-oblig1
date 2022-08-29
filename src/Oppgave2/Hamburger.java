package Oppgave2;

public class Hamburger {
    private int id;

    public Hamburger(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("◖%d◗", id);
    }
}
