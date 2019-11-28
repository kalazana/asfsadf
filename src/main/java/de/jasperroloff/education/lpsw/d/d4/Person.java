package de.jasperroloff.education.lpsw.d.d4;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 * <p>
 * Objects of this class reflect person items from the xml
 */
public class Person {
    private static final String personTag = "person";
    private static final String vornameTag = "vorname";
    private static final String nachnameTag = "nachname";
    private static final String aliasTag = "alias";

    private String vorname;
    private String nachname;
    private String alias;

    /**
     * instantiates a new person object from a given element
     * @param element the element object
     * @throws ContentException when there are unexpected tags or when there is incomplete/double/invalid content
     */
    public Person(Element element) throws ContentException {
        // check if the element tag equals the person tag
        if (!element.getName().equals(personTag)) {
            throw new ContentException(String.format("invalid tag used here: %s", element.getName()));
        }

        // handle each child tag
        for (Element child : element) {
            switch (child.getName()) {
                case vornameTag:
                    // check if vorname was set already
                    if (this.vorname != null) {
                        throw new ContentException(String.format("multiple '%s' tags not allowed within '%s'", vornameTag, personTag));
                    }

                    // check if vorname is empty
                    if (child.getContent().length() == 0) {
                        throw new ContentException(String.format("empty '%s' not allowed", vornameTag));
                    }

                    this.vorname = child.getContent();
                    break;
                case nachnameTag:
                    // check if nachname was set already
                    if (this.nachname != null) {
                        throw new ContentException(String.format("multiple '%s' tags not allowed within '%s'", nachnameTag, personTag));
                    }

                    // check if nachname is empty
                    if (child.getContent().length() == 0) {
                        throw new ContentException(String.format("empty '%s' not allowed", nachnameTag));
                    }

                    this.nachname = child.getContent();
                    break;
                case aliasTag:
                    // check if alias was set already
                    if (this.alias != null) {
                        throw new ContentException(String.format("multiple '%s' tags not allowed within '%s'", aliasTag, personTag));
                    }

                    // check if alias is empty
                    if (child.getContent().length() == 0) {
                        throw new ContentException(String.format("empty '%s' not allowed", aliasTag));
                    }

                    this.alias = child.getContent();
                    break;
                default:
                    // other items aren't allowed here, thus we throw an exception
                    throw new ContentException(String.format("tag '%s' not allowed within '%s'", child.getName(), personTag));
            }
        }

        // check if an attribute wasn't set - that happens, when the corresponding child tag is missing
        // check alias attribute
        if (this.alias == null) {
            throw new ContentException(String.format("missing '%s' tag", aliasTag));
        }

        // check nachname attribute
        if (this.nachname == null) {
            throw new ContentException(String.format("missing '%s' tag", nachnameTag));
        }

        // check vorname attribute
        if (this.vorname == null) {
            throw new ContentException(String.format("missing '%s' tag", vornameTag));
        }

        // prevent other content in the xml
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
