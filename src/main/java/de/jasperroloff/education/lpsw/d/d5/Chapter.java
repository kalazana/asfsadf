package de.jasperroloff.education.lpsw.d.d5;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 */
@XmlRootElement
public class Chapter implements Iterable<Chapter> {
    private String title;
    private ArrayList<Chapter> children = new ArrayList<>();

    public Chapter(String title) {
        this.title = title;
    }

    public void addChild(Chapter chapter) {
        this.children.add(chapter);
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    public Iterator<Chapter> iterator() {
        return this.children.iterator();
    }
}
