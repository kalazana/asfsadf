package de.jasperroloff.education.lpsw.d.d4;

/**
 * @author jasperroloff
 * This Exception is thrown when it comes to an error while handling the parsed content and trying to generate objects from it
 */
public class ContentException extends Exception {
    public ContentException(String message) {
        super(message);
    }
}
