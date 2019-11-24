package d5;

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

public class WikipediaBooksContributorRequest {
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            throw new Exception("no title parameter provided!");
        }

        final String title = args[0];
        System.out.println("Suche nach: " + title);

        try {
            System.out.println(readPageInfo(title).getLatestRevision());
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
        connection.setDoInput(true);
        InputStream inStream = connection.getInputStream();
        InputSource inputSource = new InputSource(inStream);
        xmlReader.parse(inputSource);
        MediaWikiPage page = pageInfoContentHandler.getPage();
        page.setUrl(url.toString());
        return page;
    }
}
