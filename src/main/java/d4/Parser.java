package d4;

public class Parser {
    enum ParseState {
        ELEMENT_START,
        ELEMENT_END,
        CONTENT,
    }

    private XmlHandler xmlHandler;
    private String xml;
    private int position = 0;
    private StringBuilder currentInput = new StringBuilder();
    private ParseState state = ParseState.CONTENT;

    public Parser(XmlHandler xmlHandler) {
        this.xmlHandler = xmlHandler;
    }

    public void parse(String xml) throws ParseException {
        this.xml = xml;

        while (this.position < xml.length()) {
            this.readChar();
        }
    }

    private void readChar() throws ParseException {
        String remaining = this.xml.substring(this.position);

        if (this.state == ParseState.CONTENT) {
            switch (remaining.charAt(0)) {
                case '>':
                    throw new ParseException(String.format("unexpected char at position %d", this.position));
                case '<':
                    this.xmlHandler.onElementContent(this.currentInput.toString());
                    this.currentInput.setLength(0);
                    if (remaining.length() > 1 && remaining.charAt(1) == '/') {
                        this.state = ParseState.ELEMENT_END;
                        position += 2;
                    } else {
                        this.state = ParseState.ELEMENT_START;
                        position++;
                    }
                    break;
                default:
                    this.currentInput.append(remaining.charAt(0));
                    position++;
                    break;
            }
        } else {
            switch (remaining.charAt(0)) {
                case '>':
                    if (this.state == ParseState.ELEMENT_START) {
                        this.xmlHandler.onElementStart(this.currentInput.toString());
                    } else {
                        this.xmlHandler.onElementEnd(this.currentInput.toString());
                    }
                    this.currentInput.setLength(0);
                    this.state = ParseState.CONTENT;
                    this.position++;
                    break;
                case '<':
                    throw new ParseException(String.format("unexpected char at position %d", this.position));
                case ' ':
                case '\t':
                case '\r':
                case '\n':
                    position++;
                    break;
                default:
                    this.currentInput.append(remaining.charAt(0));
                    position++;
                    break;
            }
        }
    }
}
