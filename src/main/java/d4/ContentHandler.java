package d4;

import java.util.ArrayList;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 * <p>
 * This class is used for handling parsed xml content and generating objects from it
 */
public class ContentHandler {
    private XmlHandler xmlHandler;

    /**
     * instantiates a new content handler
     * @param xmlHandler the xmlHandler to use for reading the root element
     */
    public ContentHandler(XmlHandler xmlHandler) {
        this.xmlHandler = xmlHandler;
    }

    /**
     * gets the root element from the xmlHandler and generates team objects from it
     * @return list of teams
     * @throws ParseException when there occurs an error while parsing (invalid xml)
     * @throws ContentException when there occurs an error while handling the content (invalid structure)
     */
    public ArrayList<Team> readTeams() throws ParseException, ContentException {
        Element root = this.xmlHandler.getRootElement();

        ArrayList<Team> teams = new ArrayList<>();

        for (Element child : root) {
            teams.add(new Team(child));
        }

        return teams;
    }
}
