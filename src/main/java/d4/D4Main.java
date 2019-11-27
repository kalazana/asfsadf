package d4;

import java.util.ArrayList;

public class D4Main {
    // 1. example from exercise (should work)
    private static final String example1 = "<team><person><vorname>Norrin</vorname> <nachname>Radd</nachname><alias>Silver Surfer</alias></person><person><vorname>Ben</vorname><nachname>Grimm</nachname><alias>Das Ding</alias></person></team>";
    // 2. fixed example from exercise (different tag order, should work)
    private static final String example2 = "<team><person><nachname>Radd</nachname> <vorname>Norrin</vorname><alias>Silver Surfer</alias></person> <person><vorname>Ben</vorname><alias>Das Ding</alias><nachname>Grimm</nachname></person></team>";
    // 3. example from exercise (invalid tags, shouldn't work)
    private static final String example3 = "<team><person><nachname>Radd></nachname><alias>Silver Surfer</alias> <vorname>Norrin</vorname></person> <mensch><vorname>Ben</vorname><nachname>Grimm</nachname><alias>Das Ding</alias></person></team>";
    // multiple team tags (should work)
    private static final String example4 = "<team><person><nachname>N1</nachname><vorname>V1</vorname><alias>A1</alias></person></team><team><person><nachname>N2</nachname><vorname>V2</vorname><alias>A2</alias></person></team>";
    // 'vorname' tag missing (shouldn't work)
    private static final String example5 = "<team><person><nachname>N1</nachname><alias>A1</alias></person></team>";
    // 'nachname' tag missing (shouldn't work)
    private static final String example6 = "<team><person><vorname>V1</vorname><alias>A1</alias></person></team>";
    // 'person' tag missing (should work -> empty team)
    private static final String example7 = "<team></team>";
    // 'team' tag(s) missing (should work -> empty list of teams)
    private static final String example8 = "";

    public static void main(String[] args) throws Exception {
        XmlHandler xmlHandler = new XmlHandler();
        Parser parser = new Parser(xmlHandler);
        parser.parse(example1);

        printElement(xmlHandler.getRootElement(), 0);

        ArrayList<Team> teams = new ContentHandler(xmlHandler).readTeams();
        for (int i = 0; i < teams.size(); i++) {
            System.out.println();
            System.out.println(String.format("Team %d:", i + 1));

            for (Person person : teams.get(i).getMembers()) {
                System.out.println("\t" + person.toString());
            }
        }
    }

    private static void printElement(Element element, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("\t");
        }

        System.out.println(element.getName() + " : " + element.getContent());

        for (Element child : element) {
            printElement(child, depth + 1);
        }
    }
}
