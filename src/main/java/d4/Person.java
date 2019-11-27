package d4;

public class Person {
    private static final String personTag = "person";
    private static final String vornameTag = "vorname";
    private static final String nachnameTag = "nachname";
    private static final String aliasTag = "alias";

    private String vorname;
    private String nachname;
    private String alias;

    public Person(Element element) throws ContentException {
        if (!element.getName().equals(personTag)) {
            throw new ContentException(String.format("invalid tag used here: %s", element.getName()));
        }

        for (Element child : element) {
            switch (child.getName()) {
                case vornameTag:
                    if (this.vorname != null) {
                        throw new ContentException(String.format("multiple '%s' tags not allowed within '%s'", vornameTag, personTag));
                    }

                    if (child.getContent().length() == 0) {
                        throw new ContentException(String.format("empty '%s' not allowed", vornameTag));
                    }

                    this.vorname = child.getContent();
                    break;
                case nachnameTag:
                    if (this.nachname != null) {
                        throw new ContentException(String.format("multiple '%s' tags not allowed within '%s'", nachnameTag, personTag));
                    }

                    if (child.getContent().length() == 0) {
                        throw new ContentException(String.format("empty '%s' not allowed", nachnameTag));
                    }

                    this.nachname = child.getContent();
                    break;
                case aliasTag:
                    if (this.alias != null) {
                        throw new ContentException(String.format("multiple '%s' tags not allowed within '%s'", aliasTag, personTag));
                    }

                    if (child.getContent().length() == 0) {
                        throw new ContentException(String.format("empty '%s' not allowed", aliasTag));
                    }

                    this.alias = child.getContent();
                    break;
                default:
                    throw new ContentException(String.format("tag '%s' not allowed within '%s'", child.getName(), personTag));
            }
        }

        if (this.alias == null) {
            throw new ContentException(String.format("missing '%s' tag", aliasTag));
        }

        if (this.nachname == null) {
            throw new ContentException(String.format("missing '%s' tag", nachnameTag));
        }

        if (this.vorname == null) {
            throw new ContentException(String.format("missing '%s' tag", vornameTag));
        }

        if (element.getContent().length() > 0) {
            throw new ContentException(String.format("raw content in '%s' tag not allowed", personTag));
        }
    }

    public String getAlias() {
        return alias;
    }

    public String getNachname() {
        return nachname;
    }

    public String getVorname() {
        return vorname;
    }

    @Override
    public String toString() {
        return String.format("%s %s - %s", this.vorname, this.nachname, this.alias);
    }
}
