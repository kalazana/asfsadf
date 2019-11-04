package c4c5c6c7c8;

import java.net.URL;
import java.util.Formatter;

public class ElektronischesMedium extends Medium {
    private String url;

    /**
     * Gibt die URL des elektronischen Mediums zurück
     * @return URL des elektr. Mediums
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setzt die URL des elektronischen Mediums
     * @param url URL
     */
    public void setUrl(String url) {
        if (!ElektronischesMedium.checkURL(url)) {
            System.out.println("Fehler: ungültige URL!");
        };
        this.url = url;
    }

    /**
     * Gibt die Text-Repräsentation des elektronischen Mediums zurück
     * @return Text-Repräsentation des elektronischen Mediums
     * @see Medium#calculateRepresentation()
     */
    @Override
    public String calculateRepresentation() {
        StringBuilder stringBuilder = new StringBuilder();
        Formatter formatter = new Formatter(stringBuilder);

        // Titel
        formatter.format("Titel: %s", this.getTitel());
        stringBuilder.append(System.getProperty("line.separator"));

        // URL
        formatter.format("URL: %s", this.getUrl());
        stringBuilder.append(System.getProperty("line.separator"));

        return stringBuilder.toString();
    }

    /**
     * Prüft eine URL auf Gültigkeit
     * @param urlString URL als String
     * @return true für gültig, false für ungültig
     */
    public static boolean checkURL(String urlString) {
        try {
            URL url = new URL(urlString);
            url.toURI();
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}