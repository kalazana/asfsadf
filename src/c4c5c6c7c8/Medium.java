package c4c5c6c7c8;

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

    public void validate() throws ValidationException {
        // validate field titel
        if (this.titel == null || this.titel.equals("")) {
            throw new ValidationException("empty title not allowed");
        }
    };

    public static class ValidationException extends Exception {
        protected ValidationException(String message) {
            super(message);
        }
    }
}
