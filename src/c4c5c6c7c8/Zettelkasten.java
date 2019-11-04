package c4c5c6c7c8;

import java.util.ArrayList;
import java.util.Iterator;

// TODO: add javadoc

public class Zettelkasten implements Iterable {
    private ArrayList<Medium> mediumArrayList = new ArrayList<>();

    public void addMedium(Medium medium) {
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

    public void sort() {
        // TODO
    }

    @Override
    public Iterator iterator() {
        return mediumArrayList.iterator();
    }
}
