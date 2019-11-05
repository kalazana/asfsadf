package c4c5c6c7c8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

// TODO: add javadoc

public class Zettelkasten implements Iterable<Medium> {
    private ArrayList<Medium> mediumArrayList = new ArrayList<>();

    public void addMedium(Medium medium) throws Medium.ValidationException {
        // check if all fields are valid
        medium.validate();

        // add media to list
        mediumArrayList.add(medium);
    }

    public void dropMedium(String title) throws DuplicateEntryException, EntryNotFoundException {
        ArrayList<Medium> results = new ArrayList<>();

        // iterate through ArrayList and compare titles
        for (Medium medium : mediumArrayList) {
            if (medium.getTitel().equals(title)) {
                // add medium to results list
                results.add(medium);
            }
        }

        if (results.size() > 1) {
            throw new DuplicateEntryException();
        } else if (results.size() == 0) {
            throw new EntryNotFoundException();
        } else {
            results.remove(results.get(0));
        }
    }

    public void dropMedium(String title, int index) throws EntryNotFoundException {
        if (index < 0) {
            throw new IllegalArgumentException("index can't be lower than 0");
        }

        ArrayList<Medium> results = this.findMedium(title);

        if (results.size() > index) {
            mediumArrayList.remove(index);
        }

        throw new EntryNotFoundException();
    }

    public ArrayList<Medium> findMedium(String title) {
        ArrayList<Medium> results = new ArrayList<>();

        // iterate through ArrayList and compare titles
        for (Medium medium : mediumArrayList) {
            if (medium.getTitel().equals(title)) {
                // add medium to results list
                results.add(medium);
            }
        }

        // order by type
        results.sort(Comparator.comparing(a -> a.getClass().getCanonicalName()));

        // return results
        return results;
    }

    /**
     * sorts the internal ArrayList by media title from a-z
     * @param reversed if true, sorting will be done from z-a instead a-z
     */
    public void sort(boolean reversed) {
        // A-Z
        this.mediumArrayList.sort(Comparator.naturalOrder());

        if (reversed) {
            this.mediumArrayList.sort(Comparator.reverseOrder());
        }
    }


    /**
     * sorts the internal ArrayList by media title from a-z
     */
    public void sort() {
        this.sort(false);
    }

    @Override
    public Iterator<Medium> iterator() {
        return mediumArrayList.iterator();
    }

    static class DuplicateEntryException extends Exception {
        DuplicateEntryException() {
            super();
        }
    }

    static class EntryNotFoundException extends Exception {
        EntryNotFoundException() {
            super();
        }
    }
}
