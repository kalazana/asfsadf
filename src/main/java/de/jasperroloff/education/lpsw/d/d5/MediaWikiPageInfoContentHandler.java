package de.jasperroloff.education.lpsw.d.d5;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 * Originally copied from http://blog.mynotiz.de/programmieren/java-sax-parser-tutorial-773/
 */
public class MediaWikiPageInfoContentHandler implements ContentHandler {
    private StringBuilder currentText = new StringBuilder();
    private MediaWikiPage page = null;
    private MediaWikiPageRevision revision = null;
    private MediaWikiPageContributor contributor = null;

    @Override
    public void characters(char[] ch, int start, int length) {
        currentText.append(ch, start, length);
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
        final String content = currentText.toString().trim();
        currentText.setLength(0);

        if (contributor != null) {
            switch (localName) {
                case "ip":
                    contributor.setIp(content);
                    break;
                case "username":
                    contributor.setUsername(content);
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
                        Date date = datumsformat.parse(content);
                        revision.setTimestamp(date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case "text":
                    // read regal info
                    Pattern regalPattern = Pattern.compile("(?<=\\{\\{Regal\\|)\\w+(?=}})");
                    Matcher regalMatcher = regalPattern.matcher(content);
                    if (regalMatcher.find()) {
                        String regal = regalMatcher.group();
                        page.setRegal(regal);
                    }

                    // search for "__TOC__" and use this as beginning to parse TOC
                    String toc = content.substring(content.indexOf("__TOC__"));

                    // regex101.com is a big help here: https://regex101.com/r/NYPNcI/1
                    Pattern chapterPattern = Pattern.compile("((?<=== )\\w*(?= ===))|((?<==== \\[\\[).*\\|\\w+(\\s\\w+)*(?=]] ===))");
                    Matcher chapterMatcher = chapterPattern.matcher(toc);

                    // read until no more chapters are found
                    while (chapterMatcher.find()) {
                        // sometimes the title is a link, then we have to get the link title and not the complete link tag
                        String title = chapterMatcher.group();
                        if (chapterMatcher.group(1) == null) {
                            title = title.split("\\|")[1];
                        }

                        // add the chapter to our revision
                        Chapter chapter = new Chapter(title);
                        revision.addChapter(chapter);
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
                    page.setTitel(content);
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