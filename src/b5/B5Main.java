package b5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Erklärung: Da ein BufferedWriter genutzt wird, werden die Ausgaben gepuffert in die Datei geschrieben und nicht sofort.
 * Um das Schreiben zu erzwingen und den Pufferinhalt in die Datei zu schreiben, muss .flush() aufgerufen werden.
 * Deshalb die Datei ist vor dem Aufruf von out.flush() noch leer und enthält nach dem Aufruf den Text.
 */
public class B5Main {
    public static void main(String[] args) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("test_utf8.txt"));
            out.write("Lorem ipsum dolor sit amet");
            out.flush(); // hier Breakpoint setzen
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
