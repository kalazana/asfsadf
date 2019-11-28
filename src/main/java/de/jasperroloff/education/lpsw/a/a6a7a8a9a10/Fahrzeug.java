package de.jasperroloff.education.lpsw.a.a6a7a8a9a10;

import java.util.Formatter;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 */
public abstract class Fahrzeug {
    private int baujahr;

    public Fahrzeug(int baujahr) {
        this.baujahr = baujahr;
    }

    public abstract void fahre();

    public int getBaujahr() {
        return baujahr;
    }

    public void setBaujahr(int baujahr) {
        this.baujahr = baujahr;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Formatter formatter = new Formatter(stringBuilder);
        formatter.format("Bj. %d", this.getBaujahr());
        return stringBuilder.toString();
    }
}
