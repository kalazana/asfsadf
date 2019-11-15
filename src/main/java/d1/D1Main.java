package d1;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 * Copied from http://blog.mynotiz.de/programmieren/java-sax-parser-tutorial-773/
 */
public class D1Main {
    public static void main(String[] args) {
        try {
            // XMLReader erzeugen
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            // Pfad zur XML Datei
            FileReader reader = new FileReader("personen.xml");
            InputSource inputSource = new InputSource(reader);

            // DTD kann optional übergeben werden
            // inputSource.setSystemId("X:\\personen.dtd");

            // PersonenContentHandler wird übergeben
            xmlReader.setContentHandler(new PersonenContentHandler());

            // Parsen wird gestartet
            xmlReader.parse(inputSource);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
