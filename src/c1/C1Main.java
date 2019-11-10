package c1;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 */
public class C1Main {
    private static ArrayList<Person> persons = new ArrayList<>();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // create address
        Address addr = new Address("Stralsund", "Zur Schwedenschanze 15");

        // create both persons, assign address via constructor
        Person hugo = new Person("Hugo", addr);
        Person erika = new Person("Erika", addr);

        // add both persons to ArrayList
        persons.add(hugo);
        persons.add(erika);

        // write ArrayList object to file
        ObjectOutput output = new ObjectOutputStream(new FileOutputStream("obj.ser"));
        output.writeObject(persons);
        output.close();

        // read ArrayList object from file
        ObjectInput input = new ObjectInputStream(new FileInputStream("obj.ser"));
        persons = (ArrayList<Person>) input.readObject();
        input.close();

        // iterate through parsed (!) ArrayList object
        for (Person p : persons) {
            // print current person's address' identity hash code
            // if hash codes are equal, the address object is the same one for both persons and was parsed only once
            System.out.printf("Address ID of %s is %d", p.getName(), System.identityHashCode(p.getAddress()));
            System.out.println();
        }
    }
}
