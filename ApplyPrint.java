package uebung5;
import java.util.function.IntPredicate;


public class ApplyPrint {

    public static void applyAndPrint(int i, int j, MyFunction f) {
        for (; i <= j; i++) {
            System.out.print(f.apply(i) + "  ");
        }
        System.out.println();
    }

    //-------------------------Anonyme--------------------------------

    /**
     * Anonyme Klasse, die die Quadratzahl für i berechnet
     */
    public static void squareAnonym(int i, int j) {
        System.out.print("Square Anonymous : ");
        
        
        MyFunction nanonXSquare =  new MyFunction() {
            @Override
            public int apply(int i) {
                return i * i;
            }
        };
        
        applyAndPrint(i, j, nanonXSquare);
    }


    /**
     * Anonyme Klasse, die die Fakultät einer Zahl berechnet
     */
    public static void facultyAnonym(int i, int j) {
        System.out.print("Faculty Anonymous : ");
        applyAndPrint(i, j, new MyFunction() {
            @Override
            public int apply(int i) {
                if (i < 0)
                    throw new IllegalArgumentException("Faculty for negative is not defined");
                int result = 1;
                for (int a=1; a<=i; a++) {
                    result =result* a;
                }
                return result;
            }
        });
    }


    public static void expontialAnonym(int i, int j) {
        System.out.print("Exponential Anonymous :");
        applyAndPrint(i, j, new MyFunction() {
            @Override
            public int apply(int i) {
                return (int) Math.pow(i, i + 1);
            }
        });
    }


    public static void fibonacciAnonym(int i, int j) {
        System.out.print("Fibonacci Anonymous :");
        applyAndPrint(i, j, new MyFunction() {
            @Override
            public int apply(int i) {
                int a = 0, b = 1, c;
                if (i == 0)
                    return 0;
                for (int j = 2; j <= i; j++) {
                    c = a + b;
                    a = b;
                    b = c;
                }
                return b;
            }
        });
    }

    /**
     * Lambda Ausdrück, die die Quadratzahl für i berechnet
     */
    public static void squareLambda(int i, int j) {
        System.out.print("Square lambda : ");
        MyFunction lambdaXsquare = x -> x * x;
        
        applyAndPrint(i, j, lambdaXsquare);
    }

    /**
     * Lambda Ausdrück, die die Fakultät einer Zahl berechnet
     */
    public static void facLambda(int i, int j) {
        System.out.print("Faculty lambda : ");
        applyAndPrint(i, j, x -> {
            if (x < 0) {
                throw new IllegalArgumentException("fac for negative is not defined");
            }
            int result = 1;
            if (x == 0) {
                return 1;
            }
            for (int a = x; a >= 1; a--) {
                result *= a;
            }
            return result;
        });
    }

    /**
     * Lambda Ausdrück, die die Fakultät einer Zahl berechnet
     */
    public static void expoLambda(int i, int j) {
        System.out.print("Exponential lambda : ");
        applyAndPrint(i, j, (x -> (int) Math.pow(x, x + 1)));
    }

    /**
     * Lambda Ausdrück, die die Fibonaccifolge berechnet
     */
    public static void fibonacciLambda(int i, int j) {
        System.out.print("Fibonacci lambda :");
        applyAndPrint(i, j, s -> {
            int x = 0, y = 1, z = 1;
            for (int a = 0; a < s; a++) {
                x = y;
                y = z;
                z = x + y;
            }
            return x;
        });

    }


    /**
     * Prädikat zum Überprüfen, ob ein gegebener Integer Wert ungerade ist
     */
    public static IntPredicate odd = new IntPredicate() {
        public boolean test(int x) {
            if(x%2!=0){
                return true;
            }
            return false;

        }
    };
    /**
     * Prädikat als Lambda Ausdruck zum Überprüfen, ob ein gegebener Integer Wert gerade ist
     */
    public static IntPredicate even = x -> (x % 2 == 0);

}
   

