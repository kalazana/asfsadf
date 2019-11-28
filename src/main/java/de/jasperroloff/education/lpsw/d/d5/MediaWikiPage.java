package de.jasperroloff.education.lpsw.d.d5;

public class MediaWikiPage extends ElektronischesMedium { // could additionally implement Buch class, but doesn't have an ISBN
    private MediaWikiPageRevision latestRevision;

    public MediaWikiPageRevision getLatestRevision() {
        return latestRevision;
    }

    public void setLatestRevision(MediaWikiPageRevision latestRevision) {
        this.latestRevision = latestRevision;
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
