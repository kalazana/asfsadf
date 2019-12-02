package de.jasperroloff.education.lpsw.d.d5;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 */
@XmlRootElement
public class MediaWikiPageContributor {
    private String username;
    private String ip;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        if (username != null && ip != null) {
            return username + " via " + ip;
        } else if (username != null) {
            return username;
        } else if (ip != null) {
            return ip + " (IP)";
        } else {
            return "?";
        }
    }
}
