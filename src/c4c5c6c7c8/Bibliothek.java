package c4c5c6c7c8;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 */
public class Bibliothek {
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
    }
}
