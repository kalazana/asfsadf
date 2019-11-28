package de.jasperroloff.education.lpsw.d.d5;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MediaWikiPageRevision {
    private Date timestamp;
    private MediaWikiPageContributor contributor;

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setContributor(MediaWikiPageContributor contributor) {
        this.contributor = contributor;
    }

    public MediaWikiPageContributor getContributor() {
        return contributor;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy 'um' HH:mm:ss 'Uhr' (Z)");

        return "Urheber: " + this.contributor + System.lineSeparator() +
                "Letzte Änderung: " + dateFormat.format(timestamp);
    }
}
