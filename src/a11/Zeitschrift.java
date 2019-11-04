package a11;

import java.util.Formatter;

public class Zeitschrift extends Medium {
    private String issn;
    private int volume;
    private int nummer;

    /**
     * Gibt die Nummer der Zeitschrift zurück
     * @return Nummer der Zeitschrift
     */
    public int getNummer() {
        return nummer;
    }

    /**
     * Setzt die Nummer der Zeitschrift
     * @param nummer Nummer der Zeitschrift
     */
    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    /**
     * Gibt das Volumen der Zeitschrift zurück
     * @return Volumen der Zeitschift
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Setzt das Volumen der Zeitschrift
     * @param volume Volumen
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * Gibt die ISSN der Zeitschrift zurück
     * @return ISSN der Zeitschrift
     */
    public String getIssn() {
        return issn;
    }

    /**
     * Setzt die ISSN der Zeitschrift
     * @param issn ISSN
     */
    public void setIssn(String issn) {
        this.issn = issn;
    }

    /**
     * Gibt die Text-Repräsentation der Zeitschrift zurück
     * @return Text-Repräsentation der Zeitschrift
     * @see Medium#calculateRepresentation()
     */
    @Override
    public String calculateRepresentation() {
        StringBuilder stringBuilder = new StringBuilder();
        Formatter formatter = new Formatter(stringBuilder);

        // Titel
        formatter.format("Titel: %s", this.getTitel());
        stringBuilder.append(System.getProperty("line.separator"));

        // ISSN
        formatter.format("ISSN: %s", this.getIssn());
        stringBuilder.append(System.getProperty("line.separator"));

        // Volume
        formatter.format("Volume: %d", this.getVolume());
        stringBuilder.append(System.getProperty("line.separator"));

        // Nummer
        formatter.format("Nummer: %d", this.getNummer());
        stringBuilder.append(System.getProperty("line.separator"));

        return stringBuilder.toString();
    }
}
