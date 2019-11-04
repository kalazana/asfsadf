package b8;

import java.io.*;

public class B8Main {
    public static void main(String[] args) {
        // String filename = "src/b8/test_utf8.txt";
        String filename = "src/b8/test_utf16.txt";

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
