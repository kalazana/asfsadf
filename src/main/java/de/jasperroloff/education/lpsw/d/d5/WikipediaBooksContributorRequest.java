package de.jasperroloff.education.lpsw.d.d5;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

// valid, username: Java_Standard
// valid, username: Die_Kunst,_glücklich_zu_leben
// not found: Die_Kunst_Glücklich_Zu_Leben

// xml timestamp: 2019-09-22T08:02:53Z
// console output: 22.09.2019 um 10:02:53 Uhr (+0200)
// browser timestamp: 22. September 2019 um 09:02 Uhr
// -> Konsolenausgabe bereits umgerechnet. Unterschied zur Zeit im Browser, weil die Zeit im Browser nicht korrekt ist
// -> am 22. September war noch Sommerzeit, daher sollte auch die Zeitzone CEST (+0200) zum Einsatz kommen

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 */
public class WikipediaBooksContributorRequest {
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            throw new Exception("no title parameter provided!");
        }

        final String title = args[0];
        System.out.println("Suche nach: " + title);

        try {
            MediaWikiPage page = readPageInfo(title);
            System.out.println(page.getLatestRevision() + "Regal: " + page.getRegal());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static MediaWikiPage readPageInfo(String title) throws Exception {
        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
        MediaWikiPageInfoContentHandler pageInfoContentHandler = new MediaWikiPageInfoContentHandler();
        xmlReader.setContentHandler(pageInfoContentHandler);
        URL url = new URL("https://de.wikibooks.org/wiki/Spezial:Exportieren/" + title);
        URLConnection connection = url.openConnection();
        // setting user-agent isn't needed, it works also without setting it
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_1) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Safari/605.1.15");
        connection.setDoInput(true);
        InputStream inStream = connection.getInputStream();
        InputSource inputSource = new InputSource(inStream);
        xmlReader.parse(inputSource);
        MediaWikiPage page = pageInfoContentHandler.getPage();
        page.setUrl(url.toString());
        return page;
    }
}
