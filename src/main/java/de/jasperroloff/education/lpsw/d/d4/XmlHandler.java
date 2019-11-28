package de.jasperroloff.education.lpsw.d.d4;

import java.util.Stack;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 * <p>
 * This class is used to handle start tags, end tags and their content and build a structure from Element objects
 */
public class XmlHandler {
    /**
     * the stack holds all parent objects/items of the object/item which currently is being processed
     */
    private Stack<Element> elementStack = new Stack<>();

    /**
     * constructor, initializes the element stack with a root-element
     */
    public XmlHandler() {
        this.elementStack.push(new Element(null));
    }

    /**
     * creates a new element in the element-structure with the given name and pushes it to the stack
     * @param name the xml tag name
     */
    public void onElementStart(String name) {
        this.elementStack.push(new Element(name));
    }

    /**
     * closes the element which is currently on the top of the stack
     * @param name the xml tag name
     * @throws ParseException when the tag name of the current top element and the given tag name don't match
     */
    public void onElementEnd(String name) throws ParseException {
        if (!this.elementStack.peek().getName().equals(name)) {
            throw new ParseException(String.format("tried to close '%s' whilst in tag '%s'", name, this.elementStack.peek().getName()));
        }

        Element current = this.elementStack.pop();
        this.elementStack.peek().addChild(current);
    }

    /**
     * handles content text and adds it to the element on top of the stack
     * @param content content text to handle
     */
    public void onElementContent(String content) {
        this.elementStack.peek().appendContent(content);
    }

    /**
     * returns the root element which contains the complete element structure
     * @return root element
     * @throws ParseException when parsing is not completed, may be the case if a closing tag is missing at the end of the file
     */
    public Element getRootElement() throws ParseException {
        if (this.elementStack.size() > 1) {
            throw new ParseException("parsing not completed");
        }

        return this.elementStack.peek();
    }
}
