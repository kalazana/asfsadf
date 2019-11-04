package c4c5c6c7c8;

import java.util.ArrayList;

public class Bibliothek {
    public static void main(String[] args) {
        ArrayList<Medium> mediumList = new ArrayList<>();

        Buch buch = new Buch();
        buch.setTitel("Duden 01. Die deutsche Rechtschreibung");
        buch.setVerfasser("-");
        buch.setVerlag("Bibliographisches Institut, Mannheim");
        buch.setIsbn("3-411-04013-0");
        buch.setErscheinungsjahr(2004);
        mediumList.add(buch);

        CD cd = new CD();
        cd.setTitel("1");
        cd.setLabel("Apple (Bea (EMI)");
        cd.setKuenstler("The Beatles");
        mediumList.add(cd);

        Zeitschrift zeitschrift = new Zeitschrift();
        zeitschrift.setTitel("Der Spiegel");
        zeitschrift.setVolume(54);
        zeitschrift.setNummer(6);
        zeitschrift.setIssn("0038-7452");
        mediumList.add(zeitschrift);

        ElektronischesMedium elektronischesMedium = new ElektronischesMedium();
        elektronischesMedium.setTitel("Hochschule Stralsund");
        elektronischesMedium.setUrl("http://www.hochschule-stralsund.de");
        mediumList.add(elektronischesMedium);

        for (Medium medium : mediumList) {
            System.out.println(medium.calculateRepresentation());
        }
    }
}
