package d4;

import java.util.ArrayList;

public class Team {
    private static final String teamTag = "team";

    private ArrayList<Person> members = new ArrayList<>();

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

    public ArrayList<Person> getMembers() {
        return members;
    }
}
