package d3;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class D3Main {
    public static void main(String[] args) {
        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            FeedContentHandler feedContentHandler = new FeedContentHandler();
            xmlReader.setContentHandler(feedContentHandler);
            URL url = new URL("http://www.tagesschau.de/xml/rss2");
            URLConnection connection = url.openConnection();
            connection.setDoInput(true);
            InputStream inStream = connection.getInputStream();
            InputSource inputSource = new InputSource(inStream);
            xmlReader.parse(inputSource);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

    }
}
