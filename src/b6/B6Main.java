package b6;

import java.io.*;

public class B6Main {
    public static void main(String[] args) {
        // String lineSeparator = System.getProperty("line.separator");
        String lineSeparator = "\r\n";
        String message = "Die Welt kostet 17 €";
        String filename = "test2.txt";

        // folgenden Block von Aufgabe b5 übernommen
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
