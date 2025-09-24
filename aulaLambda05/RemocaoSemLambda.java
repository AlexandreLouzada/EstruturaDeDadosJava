package aulaLambda05;

import java.util.*;

// Remove todos os números pares de uma lista sem usar lambdas.
// ATENÇÃO: remover enquanto itera exige Iterator para evitar ConcurrentModificationException.
public class RemocaoSemLambda {

    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

        // Usamos Iterator para varrer a lista e remover com segurança
        Iterator<Integer> it = numeros.iterator();
        while (it.hasNext()) {
            Integer valor = it.next();
            if (valor % 2 == 0) {
                it.remove(); // remove o elemento atual com segurança
            }
        }

        System.out.println("Lista sem pares [sem lambda]: " + numeros);
    }
}

