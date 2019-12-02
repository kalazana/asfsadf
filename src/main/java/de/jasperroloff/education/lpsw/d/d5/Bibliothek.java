package de.jasperroloff.education.lpsw.d.d5;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 */
public class Bibliothek {
    /**
     * Main method
     * -> Main method for exercise D5 is in class WikipediaBooksContributorRequest
     *
     * @param args _
     * @throws Medium.ValidationException _
     */
    public static void main(String[] args) throws Medium.ValidationException {
        Zettelkasten zettelkasten = new Zettelkasten();

        Buch buch = new Buch();
        buch.setTitel("Duden 01. Die deutsche Rechtschreibung");
        buch.setVerfasser("-");
        buch.setVerlag("Bibliographisches Institut, Mannheim");
        buch.setIsbn("3-411-04013-0");
        buch.setErscheinungsjahr(2004);
        zettelkasten.addMedium(buch);

        CD cd = new CD();
        cd.setTitel("1");
        cd.setLabel("Apple (Bea (EMI)");
        cd.setKuenstler("The Beatles");
        zettelkasten.addMedium(cd);

        Zeitschrift zeitschrift = new Zeitschrift();
        zeitschrift.setTitel("Der Spiegel");
        zeitschrift.setVolume(54);
        zeitschrift.setNummer(6);
        zeitschrift.setIssn("0038-7452");
        zettelkasten.addMedium(zeitschrift);

        ElektronischesMedium elektronischesMedium = new ElektronischesMedium();
        elektronischesMedium.setTitel("Hochschule Stralsund");
        elektronischesMedium.setUrl("http://www.hochschule-stralsund.de");
        zettelkasten.addMedium(elektronischesMedium);

        zettelkasten.sort();

        for (Medium medium : zettelkasten) {
            System.out.println(medium.calculateRepresentation());
        }


        try {
            System.out.println("Saving to xml ...");
            new XMLPersistency().save(zettelkasten, "example-files/zettelkasten.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Loading from xml ...");
            for (Medium medium : new XMLPersistency().load("example-files/zettelkasten.xml")) {
                System.out.println(medium.calculateRepresentation());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
        try {
            new DatabasePersistency("localhost", "lpsw").save(zettelkasten, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println("loading:");
            Zettelkasten zkNew = new DatabasePersistency("localhost", "lpsw").load(null);
            for (Medium medium : zkNew) {
                System.out.println(medium.calculateRepresentation());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
