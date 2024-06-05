package uebung5;

import java.util.Scanner;

public class Dialog {

    private final int ENDE = 0;
    private final int ANONYM = 1;
    private final int LAMBDA = 2;

    private final int GERADEUNGERADE = 3;

    private final int SQUARE = 1;
    private final int FACULTY = 2;
    private final int EXPONENT = 3;
    private final int FIBONACCI = 4;

    Scanner input = new Scanner(System.in);

    /**
     * This Method checks the all input numbers.
     *
     * @param from start the operation numbers / class numbers
     * @param to   end the operation numbers / class numbers
     * @return the input
     */
    private int getValidNumbe(int from, int to) {
        int temp = 0;
        while (true) {
            try {
                temp = input.nextInt();
                if (temp >= from && temp <= to) {
                    return temp;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                System.out.println("Nicht erlaubte Zahleingabe");
                System.out.println("Bitte nochmal gültige Zahl eingeben:");
                input.nextLine();
            }
        }
    }

    /**
     * This is the operation funktion
     *
     * @param Anonym if the choosen class is (true)Anonym or (false)Lambda .
     */
    private void executeOperations(boolean Anonym) {

        System.out.println("choose operation: " + "\n" +
                "  " + SQUARE + " :Square\n" + "  " + FACULTY + " :Faculty\n" + "  " + EXPONENT + " :Exponential\n" + "  " +
                FIBONACCI + " :Fibonacci\n  " + ENDE + " :Main Menu\n");

        int choice = getValidNumbe(0, 4);
        if (choice == ENDE) return;
        System.out.println("Erste Zahl eingeben: ");
        int firstNumber = getValidNumbe(Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("Zweite Zahl eingeben: ");
        int secondNumber = getValidNumbe(Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (secondNumber < firstNumber) {
            System.out.println("Es kann nicht gerechnet werden, denn die erste Zahl " + firstNumber + " ist grosser " +
                    "als die zweite Zahl " + secondNumber);
            return;
        }
        switch (choice) {
            case SQUARE:
                if (Anonym) {
                    ApplyPrint.squareAnonym(firstNumber, secondNumber);
                } else {
                    ApplyPrint.squareLambda(firstNumber, secondNumber);
                }
                break;
            case FACULTY:
                if (Anonym) {
                    ApplyPrint.facultyAnonym(firstNumber, secondNumber);
                } else {
                    ApplyPrint.facLambda(firstNumber, secondNumber);
                }

                break;
            case EXPONENT:
                if (Anonym) {
                    ApplyPrint.expontialAnonym(firstNumber, secondNumber);
                } else {
                    ApplyPrint.expoLambda(firstNumber, secondNumber);
                }
                break;
            case FIBONACCI:
                if (Anonym) {
                    ApplyPrint.fibonacciAnonym(firstNumber, secondNumber);
                } else {
                    ApplyPrint.fibonacciLambda(firstNumber, secondNumber);
                }
                break;
            default:
                System.out.println("Irgendwas stimmt nicht");
        }

    }


    public void Start() {
        int funktion = -1;
        while (true) {
            System.out.printf("Klasse der Operation auswählen:\n%d:Anonymous  %d:Lambda  %d:Gerade und Ungerade Situation %d:Exit%n", ANONYM, LAMBDA, GERADEUNGERADE, ENDE);
            funktion = getValidNumbe(0, 3);
            switch (funktion) {
                case ENDE:
                    System.out.println("Programm ist zu Ende");
                    return;
                case ANONYM:
                    executeOperations(true);
                    break;
                case LAMBDA:
                    executeOperations(false);
                    break;

                case GERADEUNGERADE:
                    System.out.println("Erste Zahl eingeben: ");
                    int firstNumber = getValidNumbe(Integer.MIN_VALUE, Integer.MAX_VALUE);
                    System.out.println("Zweite Zahl eingeben: ");
                    int secondNumber = getValidNumbe(Integer.MIN_VALUE, Integer.MAX_VALUE);
                    if (secondNumber < firstNumber) {
                        System.out.println("Es kann nicht gerechnet werden, denn die erste Zahl " + firstNumber + " ist grosser " +
                                "als die zweite Zahl " + secondNumber);
                        return;
                    }
                    Conditionate lambdaXsquare = x -> x * x;
                    ApplyPrint.applyAndPrint(firstNumber, secondNumber,
                            lambdaXsquare.conditionateInput(ApplyPrint.even)
                    );

                    Conditionate lambdaFaku = x -> {
                        if (x < 0) {
                            throw new IllegalArgumentException("Fakultät für negative Zahlen ist nicht definiert");
                        }
                        int result = 1;
                        if (x == 0) {
                            return 1;
                        }
                        for (int a = x; a >= 1; a--) {
                            result *= a;
                        }
                        return result;
                    };
                    ApplyPrint.applyAndPrint(firstNumber, secondNumber,
                            lambdaFaku.conditionateOutput(ApplyPrint.odd));
                    break;
                default:
                    System.out.println("invalid");
            }
        }
    }

    public static void main(String[] args) {
        new Dialog().Start();

    }
}
