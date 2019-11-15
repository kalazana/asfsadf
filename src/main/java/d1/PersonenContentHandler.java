package d1;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 * Originally copied from http://blog.mynotiz.de/programmieren/java-sax-parser-tutorial-773/
 */
public class PersonenContentHandler implements ContentHandler {
    private ArrayList<Person> allePersonen = new ArrayList<>();
    private String currentValue;
    private Person person;

    // Aktuelle Zeichen die gelesen werden, werden in eine Zwischenvariable
    // gespeichert
    public void characters(char[] ch, int start, int length) {
        currentValue = new String(ch, start, length);
    }

    // Methode wird aufgerufen wenn der Parser zu einem Start-Tag kommt
    public void startElement(String uri, String localName, String qName, Attributes atts) {
        if (localName.equals("person")) {
            // Neue Person erzeugen
            person = new Person();

            // Attribut id wird in einen Integer umgewandelt und dann zu der
            // jeweiligen Person gesetzt
            person.setId(Integer.parseInt(atts.getValue("id")));
        }
    }

    // Methode wird aufgerufen wenn der Parser zu einem End-Tag kommt
    public void endElement(String uri, String localName, String qName) {

        // Name setzen
        if (localName.equals("name")) {
            person.setName(currentValue);
        }

        // Vorname setzen
        if (localName.equals("vorname")) {
            person.setVorname(currentValue);
        }

        // Datum parsen und setzen
        if (localName.equals("geburtsdatum")) {
            SimpleDateFormat datumsformat = new SimpleDateFormat("dd.MM.yyyy");
            try {
                Date date = datumsformat.parse(currentValue);
                person.setGeburtsdatum(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        // Postleitzahl setzen
        if (localName.equals("postleitzahl")) {
            person.setPostleitzahl(currentValue);
        }

        // Ort setzen
        if (localName.equals("ort")) {
            person.setOrt(currentValue);
        }

        // Hobby setzen
        if (localName.equals("hobby")) {
            person.setHobby(currentValue);
        }

        // Lieblingsgericht setzen
        if (localName.equals("lieblingsgericht")) {
            person.setLieblingsgericht(currentValue);
        }

        // Lieblingsband setzen
        if (localName.equals("lieblingsband")) {
            person.setLieblingsband(currentValue);
        }

        // Person in Personenliste abspeichern falls Person End-Tag erreicht
        // wurde.
        if (localName.equals("person")) {
            allePersonen.add(person);
            System.out.println(person);
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