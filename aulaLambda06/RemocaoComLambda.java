package aulaLambda06;

import java.util.*;

// Mesmo problema com removeIf (recebe um Predicate<T>), geralmente implementado como lambda.
public class RemocaoComLambda {

    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

        // removeIf aplica o predicado a cada elemento e remove quando for true.
        numeros.removeIf(n -> n % 2 == 0);

        System.out.println("Lista sem pares [com lambda]: " + numeros);
    }
}

