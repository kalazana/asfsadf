package de.jasperroloff.education.lpsw.a.a3;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 */
public class A3Main {
    public static void main(String[] args) {
        /*
        Erklärung mit eigenen Worten:

        | und || bzw. & und && unterscheiden sich darin, dass das Doppelzeichen einen logischen Operator darstellt, während das einfache Zeichen nur einen bitweisen Operator darstellt.

        Also:
            |  und &  : bitweise
            || und && : logisch

        Der Unterschied ist, dass logische Operatoren (wie die Bezeichnung schon impliziert) mit logischen Werten, also true oder false, arbeiten und ggf. nur den Wert auf einer Seite des Operators aufrufen.
        Beispiel 1: a && b - Wenn a = false ist, muss b nicht erst geprüft werden, da schon gefolgert werden kann, dass der Gesamtausdruck false ist.

        Bitweise Operatoren arbeiten nicht mit den logischen Werten true oder false sondern mit den binären Darstellungen der Werte.
        Beispiel 2: Seien c und d Integer, c = 3 und d = 4: Bitweiser Operator: c & d => (int) 0, c | d => (int) 7, logischer Operator nicht ohne Weiteres möglich, da nur auf bool'sche Werte anwendbar
        Das bitweise Oder ist nicht mit der Addition zu verwechseln! Dies zeigt Beispiel 3
        Quelle: https://stackoverflow.com/a/4014559
         */

        // Beispiel 1 mit logischem Operator
        System.out.println("Start Beispiel 1, logisch");
        boolean bsp1Logic = getFalse() && getTrue();
        System.out.println("Ende Beispiel 1, logisch");

        // Beispiel 1 mit binärem Operator
        System.out.println("Start Beispiel 1, bitweise");
        boolean bsp1Bitwise = getFalse() & getTrue();
        System.out.println("Ende Beispiel 1, bitweise");

        // Beispiel 2
        int a = 3; // a = 3 : 011
        int b = 4; // b = 4 : 100

        int bsp2BitwiseAnd = a & b; // 011 AND 100 => 0 AND 1 = 0, 1 AND 0 = 0, 1 AND 0 = 0 => 000 => 0
        System.out.printf("Beispiel 2 AND ergibt: %d", bsp2BitwiseAnd);
        System.out.println();

        int bsp2BitwiseOr = a | b; // 011 OR 100 => 0 OR 1 = 1, 1 OR 0 = 1, 1 OR 0 = 1 => 111 => 7
        System.out.printf("Beispiel 2 OR ergibt: %d", bsp2BitwiseOr);
        System.out.println();

        // Beispiel 3
        int c = 3; // c = 3 : 011
        int d = 7; // d = 5 : 111

        int bsp3BitwiseOr = c | d; // 011 OR 111 => 0 OR 1 = 1, 1 OR 1 = 1, 1 OR 1 = 1 => 111 => 7
        System.out.printf("Beispiel 3 OR ergibt: %d", bsp3BitwiseOr);
        System.out.println();

        int bsp3Addition = c + d; // 3 + 7 = 10
        System.out.printf("Beispiel 3 Addition ergibt: %d", bsp3Addition);
        System.out.println();
    }

    private static boolean getFalse() {
        System.out.println("getFalse() called");
        return false;
    }

    private static boolean getTrue() {
        System.out.println("getTrue() called");
        return false;
    }
}