package de.jasperroloff.education.lpsw.d.d5;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 */
@XmlRootElement
public class MediaWikiPage extends ElektronischesMedium { // could additionally implement Buch class, but doesn't have an ISBN
    private MediaWikiPageRevision latestRevision;
    private String regal;

    public MediaWikiPageRevision getLatestRevision() {
        return latestRevision;
    }

    public void setLatestRevision(MediaWikiPageRevision latestRevision) {
        this.latestRevision = latestRevision;
    }

    public String getRegal() {
        return regal;
    }

    public void setRegal(String regal) {
        this.regal = regal;
    }

    @Override
    public void validate() throws ValidationException {
        // validate fields inherited from superclass
        super.validate();

        // validate field revision
        if (this.latestRevision == null) {
            throw new ValidationException("empty revision not allowed");
        }
    }
}
