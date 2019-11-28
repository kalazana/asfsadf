package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author jasperroloff
 */
public class D2Main {

    public static void main(String[] args) throws IOException {
        String feedUrl = "http://www.tagesschau.de/xml/rss2";
        URL url = new URL(feedUrl);
        URLConnection connection = url.openConnection();
        connection.setDoInput(true);
        InputStream inStream = connection.getInputStream();
        BufferedReader input = new BufferedReader(new InputStreamReader(inStream));
        String line;
        while ((line = input.readLine()) != null) {
            System.out.println(line);
        }
    }
}
