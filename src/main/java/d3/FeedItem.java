package d3;

import java.util.Date;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 */
public class FeedItem {
    private String title;
    private String description;
    private String link;
    private Date pubDate;
    private String content;
    private String guid;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getGuid() {
        return guid;
    }

    @Override
    public String toString() {
        return "[" + this.pubDate.toString() + "] " + this.title + " (" + this.link + ")";
    }
}
