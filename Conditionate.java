package uebung5;

import java.util.function.IntPredicate;
    
    
    @FunctionalInterface
     interface Conditionate extends MyFunction {
     /**
     *Diese Methode nimmt ein Prädikat als Argument entgegen und
     * gibt einen Lambda-Ausdruck zurück. Der Lambda-Ausdruck prüft für einen gegebenen
     * Integer-Wert, ob dieser das Prädikat erfüllt. Ist das Prädikat erfüllt, wird das Ergebnis der
     * apply-Methode des Interfaces zurückgegeben, ansonsten wird 0 zurückgegeben 
     */
      default Conditionate conditionateInput(IntPredicate predicate) {
        return x -> (predicate.test(x) ? this.apply(x) : 0);
      }
     /**
     * Diese Methode nimmt ebenfalls ein Prädikat als Argument entgegen und gibt einen Lambda-Ausdruck zurück. Der Lambda-Ausdruck prüft, ob das
     *  Ergebnis der apply-Methode das Prädikat erfüllt. Ist das Prädikat erfüllt, wird das Ergebnis zurückgegeben, ansonsten 0.
     */
      default Conditionate conditionateOutput(IntPredicate predicate) {
        return x -> (predicate.test(x) ? this.apply(x) : 0);
      }
    }


