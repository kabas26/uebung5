package uebung5;


public class Fakultat implements MyFunction {

    /**
     * Top level Klasse zum Berechnen die Fakultät einer Zahl
     */
    public int apply(int i) {
        if (i == 0) {
            return 1;
        }
        if (i < 0) {
            throw new IllegalArgumentException("Falsche Eingabe");
        }
        return i * apply(i - 1);
    }

    /**
     * Static Nested Klasse zum Berechnen die Fakultät einer Zahl
     */
    public class Nested implements MyFunction {
        public int apply(int i) {
            if (i == 0) {
                return 1;
            }
            if (i < 0) {
                throw new IllegalArgumentException("Falsche Eingabe");
            }
            return i * apply(i - 1);
        }
    }

}

