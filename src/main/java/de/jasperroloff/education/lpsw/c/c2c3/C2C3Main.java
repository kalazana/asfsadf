package de.jasperroloff.education.lpsw.c.c2c3;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 */
public class C2C3Main {
    public static void main(String[] args) {
        // create family having 2 children
        Family family1 = new Family("Hugo", "Erika");
        family1.addChild("Max");
        family1.addChild("Lisa");

        // create family having no children
        Family family2 = new Family("Hugo", "Erika");

        // print members for family1
        System.out.println("Members of family 1:");
        System.out.printf("Mother: %s; Father: %s; Children: %s",
                family1.getMember(Family.Role.MOTHER),
                family1.getMember(Family.Role.FATHER),
                family1.getMember(Family.Role.CHILDREN)
        );
        System.out.println();

        // print members for family1
        System.out.println("Members of family 2:");
        System.out.printf("Mother: %s; Father: %s; Children: %s",
                family2.getMember(Family.Role.MOTHER),
                family2.getMember(Family.Role.FATHER),
                family2.getMember(Family.Role.CHILDREN)
        );
        System.out.println();

        // create family having empty name as father
        try {
            Family family3 = new Family("", "Erika");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // create family having empty name as mother
        try {
            Family family4 = new Family("Hugo", "");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // create family having empty name as child
        try {
            Family family4 = new Family("Hugo", "Erika");
            family4.addChild("");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // create family having null as child's name
        try {
            Family family4 = new Family("Hugo", "Erika");
            family4.addChild(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // c3
        for (String name : family1) {
            System.out.println(name);
        }

        /*
        Wenn nicht vom Typ String sondern vom Typ eines speziellen Objekts, könnte man aber auf
        die Methoden des jeweiligen Objekts zugreifen und dort z.B. ein setName("...") o.ä. aufrufen.
        Dies wäre aber bei jeder anderen Implementierung genauso, die das Objekt zurückgibt (z.B. Getter-Methoden)
         */
    }
}
