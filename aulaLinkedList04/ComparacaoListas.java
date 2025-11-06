package aulaLinkedList04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ComparacaoListas {
    public static void main(String[] args) {
        int numElementos = 100_000;

        // Testando ArrayList
        List<Integer> arrayList = new ArrayList<>();
        long inicio = System.currentTimeMillis();
        for (int i = 0; i < numElementos; i++) {
            arrayList.add(0, i); // insere sempre no início
        }
        long fim = System.currentTimeMillis();
        System.out.println("Tempo ArrayList: " + (fim - inicio) + " ms");

        // Testando LinkedList
        List<Integer> linkedList = new LinkedList<>();
        inicio = System.currentTimeMillis();
        for (int i = 0; i < numElementos; i++) {
            linkedList.add(0, i); // insere sempre no início
        }
        fim = System.currentTimeMillis();
        System.out.println("Tempo LinkedList: " + (fim - inicio) + " ms");
    }
}

