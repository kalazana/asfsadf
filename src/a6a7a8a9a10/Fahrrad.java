package a6a7a8a9a10;

import java.util.Formatter;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 */
public class Fahrrad extends Fahrzeug {
    private int groesseInZoll;

    public Fahrrad(int groesseInZoll, int baujahr) {
        super(baujahr);
        this.groesseInZoll = groesseInZoll;
    }

    public void fahre() {
        System.out.println("Antreten");
    }

    public int getGroesseInZoll() {
        return groesseInZoll;
    }

    public void setGroesseInZoll(int groesseInZoll) {
        this.groesseInZoll = groesseInZoll;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Formatter formatter = new Formatter(stringBuilder);
        formatter.format("Bj. %d, %d Zoll", this.getBaujahr(), this.getGroesseInZoll());
        return stringBuilder.toString();
    }
}
