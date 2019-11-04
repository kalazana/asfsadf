package a11;

public abstract class Medium {
    private String titel;

    /**
     * Gibt den Titel des Mediums zurück
     * @return Titel des Mediums
     */
    public String getTitel() {
        return titel;
    }

    /**
     * Setzt den Titel des Mediums
     * @param titel Titel
     */
    public void setTitel(String titel) {
        this.titel = titel;
    }

    /**
     * Gibt die Text-Repräsentation des Mediums zurück
     * @return Text-Repräsentation des Mediums
     */
    public abstract String calculateRepresentation();
}
