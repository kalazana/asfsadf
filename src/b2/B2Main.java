package b2;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 */
public class B2Main {
    public static class TestObject1 {
        private int testInt = 0;

        public void setTestInt(int testInt) {
            this.testInt = testInt;
        }

        public int getTestInt() {
            return testInt;
        }
    }

    public static class TestObject2 {
        private Integer testInt = 0;

        public void setTestInt(Integer testInt) {
            this.testInt = testInt;
        }

        public Integer getTestInt() {
            return testInt;
        }
    }

    public static void main(String[] args) {
        TestObject1 object1 = new TestObject1();
        object1.setTestInt(5);

        // ints selbst sind alles Werttypen, object ist Referenztyp
        int test1 = object1.getTestInt() + 9;

        TestObject2 object2 = new TestObject2();
        // hier findet auto-boxing statt
        object2.setTestInt(5);

        // hier findet auto-unboxing statt
        int test2 = 5 + object2.getTestInt();
    }
}
