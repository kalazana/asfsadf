package de.jasperroloff.education.lpsw.d.d5;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 */
public class XMLPersistency implements Persistency {
    /**
     * @param zk       a Zettelkasten instance
     * @param filename path to file where to save
     * @throws JAXBException exception while writing to file
     * @see Persistency
     */
    @Override
    public void save(Zettelkasten zk, String filename) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Zettelkasten.class);
        Marshaller m = context.createMarshaller();
        // pretty print
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(zk, new File(filename));
    }

    /**
     * @param filename from which file to load
     * @return a Zettelkasten instance
     * @throws IOException            e.g. file not found
     * @throws ClassNotFoundException in case of parsing error
     * @see Persistency
     */
    @Override
    public Zettelkasten load(String filename) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Zettelkasten.class);
        Unmarshaller um = context.createUnmarshaller();
        return (Zettelkasten) um.unmarshal(new File(filename));
    }
}
