package de.jasperroloff.education.lpsw.d.d4;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 * <p>
 * This exception is thrown when it comes to an error while parsing the xml
 */
public class ParseException extends Exception {
    public ParseException(String message) {
        super(message);
    }
}
