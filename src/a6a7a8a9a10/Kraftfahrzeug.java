package a6a7a8a9a10;

import java.util.Formatter;

public class Kraftfahrzeug extends Fahrzeug {
    private String modell;
    private double verbrauchProKilometer;

    public Kraftfahrzeug(String _modell, double _verbrauchProKilometer, int baujahr) {
        super(baujahr);
        this.modell = _modell;
        this.verbrauchProKilometer = _verbrauchProKilometer;
    }

    public double getVerbrauchProKilometer() {
        return verbrauchProKilometer;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public void setVerbrauchProKilometer(double verbrauchProKilometer) {
        this.verbrauchProKilometer = verbrauchProKilometer;
    }

    public double verbrauch(int kilometer) {
        return this.verbrauchProKilometer * kilometer;
    }

    @Override
    public void fahre() {
        System.out.println("Gas geben");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Formatter formatter = new Formatter(stringBuilder);
        formatter.format("Bj. %d, %s, %.02f l/km", this.getBaujahr(), this.getModell(), this.getVerbrauchProKilometer());
        return stringBuilder.toString();
    }
}
