package c4c5c6c7c8;

import java.io.*;

public class HumanReadablePersistency implements Persistency {
    /**
     * @see Persistency
     * @param zk a Zettelkasten instance
     * @param filename path to file where to save
     * @throws IOException e.g. file not found
     */
    @Override
    public void save(Zettelkasten zk, String filename) throws IOException {
        OutputStreamWriter output = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(filename)));

        for (Medium medium : zk) {
            output.write(medium.calculateRepresentation());
        }

        output.close();
    }

    /**
     * @see Persistency
     * @param filename from which file to load
     * @return a Zettelkasten instance
     * @throws UnsupportedOperationException parsing from human readable persistency isn't possible at the moment
     */
    @Override
    public Zettelkasten load(String filename) {
        throw new UnsupportedOperationException();
    }
}
