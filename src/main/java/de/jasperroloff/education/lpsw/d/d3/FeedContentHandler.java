package de.jasperroloff.education.lpsw.d.d3;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 * Originally copied from http://blog.mynotiz.de/programmieren/java-sax-parser-tutorial-773/
 */
public class FeedContentHandler implements ContentHandler {
    private String currentValue;
    private FeedItem item = null;

    /**
     * Aktuelle Zeichen die gelesen werden, werden in eine Zwischenvariable gespeichert
     *
     * @param ch     ch
     * @param start  start
     * @param length lenght
     * @see ContentHandler
     */
    public void characters(char[] ch, int start, int length) {
        currentValue = new String(ch, start, length);
    }

    /**
     * Methode wird aufgerufen wenn der Parser zu einem Start-Tag kommt
     * @param uri uri
     * @param localName localName
     * @param qName qName
     * @param atts atts
     * @see ContentHandler
     */
    public void startElement(String uri, String localName, String qName, Attributes atts) {
        if (localName.equals("item")) {
            item = new FeedItem();
        }
    }

    /**
     * Methode wird aufgerufen wenn der Parser zu einem End-Tag kommt
     * @param uri uri
     * @param localName localName
     * @param qName qName
     */
    public void endElement(String uri, String localName, String qName) {
        // ensure we are inside an item before we process item-specific tags
        if (item != null) {
            if (localName.equals("title")) {
                item.setTitle(currentValue);
            }

            if (localName.equals("link")) {
                item.setLink(currentValue);
            }

            if (localName.equals("pubDate")) {
                // https://stackoverflow.com/a/16616208
                SimpleDateFormat datumsformat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss Z", Locale.US);
                try {
                    Date date = datumsformat.parse(currentValue);
                    item.setPubDate(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            if (localName.equals("description")) {
                item.setDescription(currentValue);
            }

            if (localName.equals("guid")) {
                item.setGuid(currentValue);
            }

            if (localName.equals("content:encoded")) {
                item.setContent(currentValue);
            }

            if (localName.equals("item")) {
                // System.out.println(item);
                System.out.println(item.getTitle());
                item = null;
            }
        }
    }

    public void endDocument() {
    }

    public void endPrefixMapping(String prefix) {
    }

    public void ignorableWhitespace(char[] ch, int start, int length) {
    }

    public void processingInstruction(String target, String data) {
    }

    public void setDocumentLocator(Locator locator) {
    }

    public void skippedEntity(String name) {
    }

    public void startDocument() {
    }

    public void startPrefixMapping(String prefix, String uri) {
    }
}