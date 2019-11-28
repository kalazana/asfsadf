package de.jasperroloff.education.lpsw.d.d4;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 * <p>
 * This class is used to parse the xml string and pass xml tags and content to a XmlHandler instance
 */
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

    /**
     * instantiates a new parser object
     * @param xmlHandler the XmlHandler object to use to handle start tags, end tags and content
     */
    public Parser(XmlHandler xmlHandler) {
        this.xmlHandler = xmlHandler;
    }

    /**
     * parses a given xml string
     * @param xml the string to parse
     * @throws ParseException will be thrown when an error occurs while parsing
     */
    public void parse(String xml) throws ParseException {
        this.xml = xml;

        // read the xml string char by char
        while (this.position < xml.length()) {
            this.readChar();
        }
    }

    /**
     * reads the next char of the xml
     * @throws ParseException will be thrown if an error occurs while parsing
     */
    private void readChar() throws ParseException {
        // cut off chars that were read already
        String remaining = this.xml.substring(this.position);

        // distinguish between we are inside or outside of a tag
        if (this.state == ParseState.CONTENT) {
            switch (remaining.charAt(0)) {
                case '>':
                    throw new ParseException(String.format("unexpected char at position %d", this.position));
                case '<':
                    // when start of a new tag is detected, handle input that was read until now and reset StringBuilder
                    this.xmlHandler.onElementContent(this.currentInput.toString());
                    this.currentInput.setLength(0);

                    // distinguish between opening and closing tags
                    if (remaining.length() > 1 && remaining.charAt(1) == '/') {
                        // update state
                        this.state = ParseState.ELEMENT_END;
                        // because closing tags have two symbol characters, skip the second one
                        position += 2;
                    } else {
                        // update state and position
                        this.state = ParseState.ELEMENT_START;
                        position++;
                    }
                    break;
                default:
                    // append current char to the content which currently is being read
                    this.currentInput.append(remaining.charAt(0));
                    position++;
                    break;
            }
        } else {
            switch (remaining.charAt(0)) {
                case '>':
                    // when the end of a tag was detected

                    // distinguish between opening and closing tags, call the corrent method of the XmlHandler object
                    if (this.state == ParseState.ELEMENT_START) {
                        this.xmlHandler.onElementStart(this.currentInput.toString());
                    } else {
                        this.xmlHandler.onElementEnd(this.currentInput.toString());
                    }

                    // reset StringBuilder
                    this.currentInput.setLength(0);
                    // update state
                    this.state = ParseState.CONTENT;
                    // update position
                    this.position++;
                    break;
                case '<':
                    throw new ParseException(String.format("unexpected char at position %d", this.position));
                case ' ':
                case '\t':
                case '\r':
                case '\n':
                    // ignore white spaces within tags
                    position++;
                    break;
                default:
                    // append character to the currentInput, which holds the tag name in this case
                    this.currentInput.append(remaining.charAt(0));
                    position++;
                    break;
            }
        }
    }
}
