package c2c3;

import java.util.ArrayList;
import java.util.Iterator;

public class Family implements Iterable<String> {
    private ArrayList<String> members = new ArrayList<>();

    public Family(String father, String mother) {
        this.validateName(father);
        this.validateName(mother);

        this.members.add(mother);
        this.members.add(father);
    }

    /**
     * add's a child to the family
     * @param child name of the child
     * @throws IllegalArgumentException if the child's name isn't valid
     */
    public void addChild(String child) throws IllegalArgumentException {
        this.validateName(child);

        this.members.add(child);
    }

    /**
     * get a family member by role
     * @param role role of the family member to get
     * @return name(s) as one string
     */
    public String getMember(Role role) {
        switch (role) {
            case MOTHER:
                return this.members.get(0);
            case FATHER:
                return this.members.get(1);
            case CHILDREN:
                StringBuilder children = new StringBuilder();

                for (int i = 2; i < this.members.size(); i++) {
                    children.append(this.members.get(i));
                    if (i < this.members.size() - 1) {
                        children.append(", ");
                    }
                }

                return children.toString();
            default:
                return "";
        }
    }

    /**
     * validate a name to ensure that it isn't empty
     * @param name the name to verify
     * @throws if the validation failed
     */
    private void validateName(String name) throws IllegalArgumentException {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("empty name not allowed");
        }
    }

    @Override
    public Iterator<String> iterator() {
        return members.iterator();
    }

    public enum Role {
        FATHER,
        MOTHER,
        CHILDREN;
    }
}
