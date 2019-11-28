package de.jasperroloff.education.lpsw.c.c1;

import java.io.Serializable;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 */
public class Person implements Serializable {
    private String name;
    private Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(name).append(", ").append(address.toString()) .toString();
    }
}
