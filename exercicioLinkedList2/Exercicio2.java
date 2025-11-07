package exercicioLinkedList2;

import java.util.LinkedList;

public class Exercicio2 {
    public static void main(String[] args) {
        // 1.2 – Inserção em posições específicas
        System.out.println("--- 1.2 – Inserção em posições específicas ---");
        
        // Crie uma LinkedList<Integer> contendo os números: 10, 20, 30, 40, 50
        LinkedList<Integer> numeros = new LinkedList<>();
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        numeros.add(40);
        numeros.add(50);
        System.out.println("Lista inicial: " + numeros);

        // a) Insira o valor 5 no início
        numeros.addFirst(5);
        System.out.println("Após addFirst(5): " + numeros);

        // b) Insira o valor 60 no final
        numeros.addLast(60);
        System.out.println("Após addLast(60): " + numeros);

        // c) Insira o valor 25 na posição 3 (índice 3)
        // A lista atual é [5, 10, 20, 30, 40, 50, 60]. Posição 3 é o índice 3.
        numeros.add(3, 25);
        System.out.println("Após add(3, 25): " + numeros);

        // d) Exiba a lista final
        System.out.println("Lista final: " + numeros);
        System.out.println();
    }
}
