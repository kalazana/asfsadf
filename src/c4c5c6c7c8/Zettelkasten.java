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

    public void dropMedium(String title) {
        // iterate through ArrayList and compare titles
        for (Medium medium : mediumArrayList) {
            if (medium.getTitel().equals(title)) {
                // delete if media was found
                mediumArrayList.remove(medium);
                break;
            }
        }
    }

    public Medium findMedium(String title) {
        // iterate through ArrayList and compare titles
        for (Medium medium : mediumArrayList) {
            if (medium.getTitel().equals(title)) {
                // if found, return item
                return medium;
            }
        }

        // return null if media wasn't found
        return null;
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
}
