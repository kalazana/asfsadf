package d4;

import java.util.ArrayList;
import java.util.Iterator;

public class Element implements Iterable<Element> {
    private String name;
    private StringBuilder content = new StringBuilder();
    private ArrayList<Element> children = new ArrayList<>();

    public Element(String name) {
        this.name = name;
    }

    public void addChild(Element child) {
        this.children.add(child);
    }

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
