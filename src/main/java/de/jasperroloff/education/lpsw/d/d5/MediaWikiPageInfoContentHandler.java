package de.jasperroloff.education.lpsw.d.d5;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 * Originally copied from http://blog.mynotiz.de/programmieren/java-sax-parser-tutorial-773/
 */
public class MediaWikiPageInfoContentHandler implements ContentHandler {
    private String currentValue;
    private MediaWikiPage page = null;
    private MediaWikiPageRevision revision = null;
    private MediaWikiPageContributor contributor = null;

    public void characters(char[] ch, int start, int length) {
        currentValue = new String(ch, start, length);
    }

    public void startElement(String uri, String localName, String qName, Attributes atts) {
        switch (localName) {
            case "page":
                page = new MediaWikiPage();
                break;
            case "revision":
                revision = new MediaWikiPageRevision();
                break;
            case "contributor":
                contributor = new MediaWikiPageContributor();
                break;
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if (contributor != null) {
            switch (localName) {
                case "ip":
                    contributor.setIp(currentValue);
                    break;
                case "username":
                    contributor.setUsername(currentValue);
                    break;
                case "contributor":
                    revision.setContributor(contributor);
                    contributor = null;
                    break;
            }
        } else if (revision != null) {
            switch (localName) {
                case "timestamp":
                    // https://docs.oracle.com/javase/9/docs/api/java/text/SimpleDateFormat.html
                    SimpleDateFormat datumsformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");

                    try {
                        Date date = datumsformat.parse(currentValue);
                        revision.setTimestamp(date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case "revision":
                    page.setLatestRevision(revision);
                    revision = null;
                    break;
            }
        } else if (page != null) {
            switch (localName) {
                case "title":
                    page.setTitel(currentValue);
                    break;
                // TODO: more attributes
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

    public MediaWikiPage getPage() throws Exception {
        if (page == null) {
            throw new Exception("no page found");
        }
        return page;
    }
}