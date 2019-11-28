package de.jasperroloff.education.lpsw.a.a6a7a8a9a10;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 */
public class A6A7A8A9A10Main {
    public static void main(String[] args) {
        // A6
        Kraftfahrzeug[] autoArr = new Kraftfahrzeug[2];
        //Der Focus verbraucht 6,5 Liter auf 100 km:
        autoArr[0] = new Kraftfahrzeug("Focus", 0.065, 2019);
        //Der Tesla verbraucht 0 Liter auf 100 km:
        autoArr[1] = new Kraftfahrzeug("Tesla", 0.00, 2019);

        int km = 400;
        System.out.printf("Verbrauch auf %d km:%n", km);
        for (int i = 0; i < autoArr.length; i++) {
            System.out.printf("%s: %.0f Liter %n",
                    autoArr[i].getModell(),
                    autoArr[i].verbrauch(km));
        }

        // A8
        Fahrzeug[] fahrzeugArr = new Fahrzeug[2];
        fahrzeugArr[0] = new Kraftfahrzeug("Golf", 0.065, 2019);
        fahrzeugArr[1] = new Fahrrad(28, 2019);
        for (int j = 0; j < 2; j++) { // late-binding
            fahrzeugArr[j].fahre();
        }

        // A9
        Fahrzeug golf = new Kraftfahrzeug("Golf", 0.065, 1995);
        Fahrrad gurke = new Fahrrad(28, 1974);

        // A10
        System.out.println(golf);
        System.out.println(gurke);

    }
}
