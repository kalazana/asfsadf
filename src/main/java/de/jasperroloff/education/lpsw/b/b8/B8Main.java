package de.jasperroloff.education.lpsw.b.b8;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 */
public class B8Main {
    public static void main(String[] args) {
        // String filename = "src/de.jasperroloff.education.lpsw.b.b8/test_utf8.txt";
        String filename = "src/de.jasperroloff.education.lpsw.b.b8/test_utf16.txt";

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
