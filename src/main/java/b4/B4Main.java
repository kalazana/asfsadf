package b4;

import java.io.*;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 */
public class B4Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Bitte einen Dateinamen/-pfad eingeben:");

        // read filename from console input
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        String path = inputReader.readLine();

        // instantiate file object with given path
        File file = new File(path);

        try {
            // open file
            FileInputStream inputStream = new FileInputStream(file);

            // read file byte for byte until EOF
            while (inputStream.available() > 0) {
                // print byte encoded as char
                System.out.print(encodeChar(inputStream.read()));
            }

            // close file
            inputStream.close();

            // print a line break
            System.out.println();
        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static int decodeChar (char c) {
        return ((int) c);
    }

    public static char encodeChar (int i) {
        return ((char) i);
    }
}
