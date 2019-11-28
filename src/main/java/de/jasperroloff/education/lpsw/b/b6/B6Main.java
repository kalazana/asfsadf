package de.jasperroloff.education.lpsw.b.b6;

import java.io.*;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 */
public class B6Main {
    public static void main(String[] args) {
        // String lineSeparator = System.getProperty("line.separator");
        String lineSeparator = "\r\n";
        String message = "Die Welt kostet 17 €";
        String filename = "example-files/test2.txt";

        // folgenden Block von Aufgabe de.jasperroloff.education.lpsw.b.b5 übernommen
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(filename));
            out.write(message);
            out.write(lineSeparator);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Ende des übernommen Blocks

        try {
            // instantiate File object
            File file = new File(filename);

            // open file
            FileInputStream fileInputStream = new FileInputStream(file);

            // read byte by byte
            while (fileInputStream.available() > 0) {
                // print byte
                System.out.print(fileInputStream.read());
                System.out.print(" ");
            }

            // close file
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
