package c2;

import java.util.ArrayList;

public class Family {
    private ArrayList<String> members = new ArrayList<>();

    public Family(String father, String mother) {
        this.validateName(father);
        this.validateName(mother);

        this.members.add(mother);
        this.members.add(father);
    }

    public void addChild(String child) throws IllegalArgumentException {
        this.validateName(child);

        this.members.add(child);
    }

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

    private void validateName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("empty name not allowed");
        }
    }

    public enum Role {
        FATHER,
        MOTHER,
        CHILDREN;
    }
}
