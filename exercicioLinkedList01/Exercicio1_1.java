package exercicioLinkedList01;

import java.util.LinkedList;
import java.util.List;

public class Exercicio1_1 {
    public static void main(String[] args) {
        // 1.1 – Criar e manipular uma LinkedList
        System.out.println("--- 1.1 – Criar e manipular uma LinkedList ---");
        
        // Crie uma LinkedList<String> para armazenar nomes de alunos.
        LinkedList<String> nomesAlunos = new LinkedList<>();

        // a) Adicionar 5 nomes
        nomesAlunos.add("Alice");
        nomesAlunos.add("Bruno");
        nomesAlunos.add("Carlos");
        nomesAlunos.add("Diana");
        nomesAlunos.add("Eduardo");
        System.out.println("Lista após adição: " + nomesAlunos);

        // b) Remover o primeiro nome da lista
        String primeiroNomeRemovido = nomesAlunos.removeFirst();
        System.out.println("Primeiro nome removido: " + primeiroNomeRemovido);
        System.out.println("Lista após remoção do primeiro: " + nomesAlunos);

        // c) Exibir o último nome
        String ultimoNome = nomesAlunos.getLast();
        System.out.println("Último nome: " + ultimoNome);

        // d) Exibir todos os nomes usando for-each
        System.out.println("Nomes na lista (for-each):");
        for (String nome : nomesAlunos) {
            System.out.println("- " + nome);
        }
        System.out.println();
    }
}
