package d5;

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
            return username + " (" + ip + ")";
        } else if (username != null) {
            return username;
        } else if (ip != null) {
            return ip;
        } else {
            return "UNKNOWN";
        }
    }
}
