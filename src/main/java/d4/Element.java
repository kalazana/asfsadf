package d4;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 * <p>
 * This class is used to reflect parsed xml tags and the xml structure
 */
public class Element implements Iterable<Element> {
    private String name;
    private StringBuilder content = new StringBuilder();
    private ArrayList<Element> children = new ArrayList<>();

    /**
     * instantiates a new tag with a given name
     * @param name the xml tag name
     */
    public Element(String name) {
        this.name = name;
    }

    /**
     * add a child xml object
     * @param child the child object to add
     */
    public void addChild(Element child) {
        this.children.add(child);
    }

    /**
     * appends a string to the content
     * @param content string to append
     */
    public void appendContent(String content) {
        this.content.append(content);
    }

    public String getName() {
        return this.name;
    }

    public String getContent() {
        return this.content.toString().trim();
    }

    @Override
    public Iterator<Element> iterator() {
        return this.children.iterator();
    }
}
