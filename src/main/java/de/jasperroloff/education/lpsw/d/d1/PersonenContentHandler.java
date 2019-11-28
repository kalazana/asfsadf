package de.jasperroloff.education.lpsw.d.d1;

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

    /**
     * Aktuelle Zeichen die gelesen werden, werden in eine Zwischenvariable gespeichert
     *
     * @param ch     ch
     * @param length length
     * @param start  start
     * @see ContentHandler
     */
    public void characters(char[] ch, int start, int length) {
        currentValue = new String(ch, start, length);
    }

    /**
     * Methode wird aufgerufen wenn der Parser zu einem Start-Tag kommt
     * @see ContentHandler
     */
    public void startElement(String uri, String localName, String qName, Attributes atts) {
        if (localName.equals("person")) {
            // Neue Person erzeugen
            person = new Person();

            // Attribut id wird in einen Integer umgewandelt und dann zu der
            // jeweiligen Person gesetzt
            person.setId(Integer.parseInt(atts.getValue("id")));
        }
    }

    /**
     * Methode wird aufgerufen wenn der Parser zu einem End-Tag kommt
     * @param uri uri
     * @param localName localName
     * @param qName qName
     * @see ContentHandler
     */
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

    /**
     * returns a list of all parsed person items
     * @return list of person items
     */
    public ArrayList<Person> getAllePersonen() {
        return allePersonen;
    }

    /**
     * prints the current list as xml to console
     */
    public void print() {
        System.out.println("<?xml version=\"1.0\"?>");
        System.out.println("<personen>");

        for (Person person : allePersonen) {
            // start person element
            System.out.printf("\t<person id=\"%d\">", person.getId());
            System.out.println();

            // name
            System.out.printf("\t\t<name>%s</name>", person.getName());
            System.out.println();

            // vorname
            System.out.printf("\t\t<vorname>%s</vorname>", person.getVorname());
            System.out.println();

            // geburtsdatum
            System.out.printf("\t\t<geburtsdatum>%td.%<tm.%<tY</geburtsdatum>", person.getGeburtsdatum());
            System.out.println();

            // postleitzahl
            System.out.printf("\t\t<postleitzahl>%s</postleitzahl>", person.getPostleitzahl());
            System.out.println();

            // ort
            System.out.printf("\t\t<ort>%s</ort>", person.getOrt());
            System.out.println();

            // hobby
            System.out.printf("\t\t<hobby>%s</hobby>", person.getHobby());
            System.out.println();

            // lieblingsgericht
            System.out.printf("\t\t<lieblingsgericht>%s</lieblingsgericht>", person.getLieblingsgericht());
            System.out.println();

            // lieblingsband
            System.out.printf("\t\t<lieblingsband>%s</lieblingsband>", person.getLieblingsband());
            System.out.println();

            // end person element
            System.out.println("\t</person>");
        }

        System.out.println("</personen>");
    }
}