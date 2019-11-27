package d4;

import java.util.Stack;

public class XmlHandler {
    private Stack<Element> elementStack = new Stack<>();

    public XmlHandler() {
        this.elementStack.push(new Element(null));
    }

    public void onElementStart(String name) {
        this.elementStack.push(new Element(name));
    }

    public void onElementEnd(String name) throws ParseException {
        if (!this.elementStack.peek().getName().equals(name)) {
            throw new ParseException(String.format("tried to close '%s' whilst in tag '%s'", name, this.elementStack.peek().getName()));
        }

        Element current = this.elementStack.pop();
        this.elementStack.peek().addChild(current);
    }

    public void onElementContent(String content) {
        this.elementStack.peek().appendContent(content);
    }

    public Element getRootElement() throws ParseException {
        if (this.elementStack.size() > 1) {
            throw new ParseException("parsing not completed");
        }

        return this.elementStack.peek();
    }
}
