package c4c5c6c7c8;

import java.io.IOException;

public interface Persistency {
    public void save(Zettelkasten zk, String filename) throws IOException;
    public Zettelkasten load(String filename) throws IOException, ClassNotFoundException;
}
