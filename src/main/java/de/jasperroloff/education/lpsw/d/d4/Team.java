package de.jasperroloff.education.lpsw.d.d4;

import java.util.ArrayList;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 * <p>
 * Objects of this class reflect team items from the xml
 */
public class Team {
    private static final String teamTag = "team";

    private ArrayList<Person> members = new ArrayList<>();

    /**
     * constructor, instantiates the team object from a given element object
     * @param element the element object which reflects the team item
     * @throws ContentException when there are unexpected tags or a child item is invalid
     */
    public Team(Element element) throws ContentException {
        if (!element.getName().equals(teamTag)) {
            throw new ContentException(String.format("invalid tag used here: %s", element.getName()));
        }

        for (Element child : element) {
            this.members.add(new Person(child));
        }

        if (element.getContent().length() > 0) {
            throw new ContentException(String.format("raw content in '%s' tag not allowed", teamTag));
        }
    }

    /**
     * @return members list of the team
     */
    public ArrayList<Person> getMembers() {
        return members;
    }
}
