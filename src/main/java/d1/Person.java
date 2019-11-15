package d1;

import java.util.Date;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 * Originally copied from http://blog.mynotiz.de/programmieren/java-sax-parser-tutorial-773/
 */
public class Person {
    private int id;
    private String name;
    private String vorname;
    private Date geburtsdatum;
    private String postleitzahl;
    private String ort;
    private String hobby;
    private String lieblingsband;
    private String lieblingsgericht;

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

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getLieblingsband() {
        return lieblingsband;
    }

    public void setLieblingsband(String lieblingsband) {
        this.lieblingsband = lieblingsband;
    }

    public String getLieblingsgericht() {
        return lieblingsgericht;
    }

    public void setLieblingsgericht(String lieblingsgericht) {
        this.lieblingsgericht = lieblingsgericht;
    }

    @Override
    public String toString() {
        return "[[" + this.id + "] [" + this.name + "] [" + this.vorname + "]" + " [" + this.ort
                + "] [" + this.postleitzahl + "] [" + this.geburtsdatum + "] [" + this.hobby + "] [" + this.lieblingsband + "] [" + this.lieblingsgericht + "]]";
    }
}