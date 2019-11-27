package d4;

import java.util.ArrayList;

public class ContentHandler {
    private XmlHandler xmlHandler;

    public ContentHandler(XmlHandler xmlHandler) {
        this.xmlHandler = xmlHandler;
    }

    public ArrayList<Team> readTeams() throws ParseException, ContentException {
        Element root = this.xmlHandler.getRootElement();

        ArrayList<Team> teams = new ArrayList<>();

        for (Element child : root) {
            teams.add(new Team(child));
        }

        return teams;
    }
}
