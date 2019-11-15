package d1;

import java.util.Date;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 * Copied from http://blog.mynotiz.de/programmieren/java-sax-parser-tutorial-773/
 */
public class Person {

    private int id;
    private String name;
    private String vorname;
    private Date geburtsdatum;
    private String postleitzahl;
    private String ort;

    public Person() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public Date getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(Date geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public String getPostleitzahl() {
        return postleitzahl;
    }

    public void setPostleitzahl(String postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    @Override
    public String toString() {
        return "[[" + this.id + "] ["+ this.name + "] [" + this.vorname + "]" + " [" + this.ort
                + "] [" + this.postleitzahl + "] [" + this.geburtsdatum + " ]]";
    }
}