package a11;

public class Bibliothek {
    public static void main(String[] args) {
        Medium[] mediumArray = new Medium[4];

        Buch buch = new Buch();
        buch.setTitel("Duden 01. Die deutsche Rechtschreibung");
        buch.setVerfasser("-");
        buch.setVerlag("Bibliographisches Institut, Mannheim");
        buch.setIsbn("3-411-04013-0");
        buch.setErscheinungsjahr(2004);
        mediumArray[0] = buch;

        CD cd = new CD();
        cd.setTitel("1");
        cd.setLabel("Apple (Bea (EMI)");
        cd.setKuenstler("The Beatles");
        mediumArray[1] = cd;

        Zeitschrift zeitschrift = new Zeitschrift();
        zeitschrift.setTitel("Der Spiegel");
        zeitschrift.setVolume(54);
        zeitschrift.setNummer(6);
        zeitschrift.setIssn("0038-7452");
        mediumArray[2] = zeitschrift;

        ElektronischesMedium elektronischesMedium = new ElektronischesMedium();
        elektronischesMedium.setTitel("Hochschule Stralsund");
        elektronischesMedium.setUrl("http://www.hochschule-stralsund.de");
        mediumArray[3] = elektronischesMedium;

        for (Medium medium : mediumArray) {
            System.out.println(medium.calculateRepresentation());
        }
    }
}
