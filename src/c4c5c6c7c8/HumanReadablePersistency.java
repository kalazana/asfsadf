package c4c5c6c7c8;

import java.io.*;

public class HumanReadablePersistency implements Persistency {
    @Override
    public void save(Zettelkasten zk, String filename) throws IOException {
        OutputStreamWriter output = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(filename)));

        for (Medium medium : zk) {
            output.write(medium.calculateRepresentation());
        }

        output.close();
    }

    @Override
    public Zettelkasten load(String filename) {
        throw new UnsupportedOperationException();
    }
}
