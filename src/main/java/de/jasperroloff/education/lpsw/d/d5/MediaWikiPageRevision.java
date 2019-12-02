package de.jasperroloff.education.lpsw.d.d5;

import javax.xml.bind.annotation.XmlRootElement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 */
@XmlRootElement
public class MediaWikiPageRevision {
    private Date timestamp;
    private MediaWikiPageContributor contributor;

    private ArrayList<Chapter> chapters = new ArrayList<>();

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

    public ArrayList<Chapter> getChapters() {
        return chapters;
    }

    public void addChapter(Chapter chapter) {
        this.chapters.add(chapter);
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy 'um' HH:mm:ss 'Uhr' (Z)");

        StringBuilder string = new StringBuilder();

        string.append("Urheber: ").append(this.contributor).append(System.lineSeparator());
        string.append("Letzte Änderung: ").append(dateFormat.format(timestamp)).append(System.lineSeparator());

        if (this.chapters.size() > 0) {
            string.append("Kapitel:").append(System.lineSeparator());

            for (int i = 0; i < this.chapters.size(); i++) {
                string.append(String.format("%d %s", i + 1, chapters.get(i).getTitle())).append(System.lineSeparator());
            }
        }

        return string.toString();
    }
}
