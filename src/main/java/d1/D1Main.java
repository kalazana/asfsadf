package d1;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 * Originally copied from http://blog.mynotiz.de/programmieren/java-sax-parser-tutorial-773/
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
            // inputSource.setSystemId("personen.dtd");

            // PersonenContentHandler wird übergeben
            xmlReader.setContentHandler(new PersonenContentHandler());

            // Parsen wird gestartet
            xmlReader.parse(inputSource);

            Person neuePerson = inputPerson();
            System.out.println(neuePerson);
        } catch (IOException | SAXException | ParseException e) {
            e.printStackTrace();
        }
    }

    private static Person inputPerson() throws IOException, ParseException {
        System.out.println("Eingabe einer Person ...");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        Person person = new Person();

        System.out.print("Bitte Vornamen eingeben: ");
        person.setVorname(input.readLine().trim());

        System.out.print("Bitte Nachnamen eingeben: ");
        person.setName(input.readLine().trim());

        System.out.print("Bitte Postleitzahl eingeben: ");
        person.setPostleitzahl(input.readLine().trim());

        System.out.print("Bitte Ort eingeben: ");
        person.setOrt(input.readLine().trim());

        System.out.print("Bitte Geburtsdatum eingeben (Format: dd.MM.yyyy): ");
        SimpleDateFormat datumsformat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = datumsformat.parse(input.readLine().trim());
        person.setGeburtsdatum(date);

        System.out.print("Bitte Hobby eingeben: ");
        person.setHobby(input.readLine().trim());

        System.out.print("Bitte Lieblingsessen eingeben: ");
        person.setLieblingsgericht(input.readLine().trim());

        System.out.print("Bitte Lieblingsband eingeben: ");
        person.setLieblingsband(input.readLine().trim());

        return person;
    }
}
