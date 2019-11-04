package a4;

public class A4Main {
    public static void main(String[] args) {
        /*
        Erklärung mit eigenen Worten:

        String: unveränderliches Objekt, welches eine Zeichenkette repräsentiert
        -> Vorteil: direkte Konstruktion möglich, kein explizites Aufrufen eines Konstruktors nötig
        -> Vorteil: einfaches Vergleichen und generell einfachere Handhabung
        -> Nachteil: Nicht veränderbar, Veränderungen generieren neues Objekt
        StringBuffer: veränderliches Objekt
        -> Veränderungen betreffen Objekt selbst
        -> Vorteil bei Nebenläufigkeit: garantiert konsistenz der Daten
        -> Nachteil bei Nicht-Nebenläufigkeit: langsamer als StringBuilder
        StringBuilder: wie StringBuffer, nur nicht synchronisiert
        -> Nachteil bei Nebenläufigkeit: kann zu inkonsistenten Daten führen
        -> Vorteil bei Nicht-Nebenläufigkeit: schneller als StringBuffer
         */

        // Beispiel für String:
        String bspString = "Hello";
        System.out.println("IdentityHashCode für original-String: " + System.identityHashCode(bspString));
        bspString += " World!"; // generiert neues Objekt
        System.out.println("IdentityHashCode für veränderten String: " + System.identityHashCode(bspString));

        // Beispiel für StringBuffer
        StringBuffer bspStringBuffer = new StringBuffer();
        System.out.println("IdentityHashCode für StringBuffer (1): " + System.identityHashCode(bspStringBuffer));
        bspStringBuffer.append("Hello");
        System.out.println("IdentityHashCode für StringBuffer (2): " + System.identityHashCode(bspStringBuffer));
        bspStringBuffer.append(" World!");
        System.out.println("IdentityHashCode für StringBuffer (3): " + System.identityHashCode(bspStringBuffer));
        System.out.println(bspStringBuffer.toString());

        // Beispiel für StringBuilder
        StringBuilder bspStringBuilder = new StringBuilder();
        System.out.println("IdentityHashCode für StringBuilder (1): " + System.identityHashCode(bspStringBuilder));
        bspStringBuilder.append("Hello");
        System.out.println("IdentityHashCode für StringBuilder (2): " + System.identityHashCode(bspStringBuilder));
        bspStringBuilder.append(" World!");
        System.out.println("IdentityHashCode für StringBuilder (3): " + System.identityHashCode(bspStringBuilder));
        System.out.println(bspStringBuilder.toString());
    }
}