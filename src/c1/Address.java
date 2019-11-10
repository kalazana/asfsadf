package c1;

import java.io.Serializable;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 */
public class Address implements Serializable {
    private String city;
    private String street;

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(street).append(", ") .append(city).toString();
    }
}
