package exercicioLinkedList3;

import java.util.LinkedList;

public class Exercicio3 {
    public static void main(String[] args) {
        // 1.3 – Remover elementos específicos
        System.out.println("--- 1.3 – Remover elementos específicos ---");
        
        // Usando uma LinkedList<String>:
        LinkedList<String> linguagens = new LinkedList<>();
        
        // 1. Adicione os elementos: "Java", "Python", "C++", "Java", "Go"
        linguagens.add("Java");
        linguagens.add("Python");
        linguagens.add("C++");
        linguagens.add("Java");
        linguagens.add("Go");
        System.out.println("Lista inicial: " + linguagens);

        // 2. Remova apenas a primeira ocorrência de "Java"
        // O método remove(Object) remove a primeira ocorrência do objeto especificado.
        linguagens.remove("Java");
        System.out.println("Após remover a primeira ocorrência de 'Java': " + linguagens);

        // 3. Remova o elemento "C++"
        linguagens.remove("C++");
        System.out.println("Após remover 'C++': " + linguagens);

        // 4. Exiba o resultado
        System.out.println("Resultado final: " + linguagens);
        System.out.println();
    }
}
