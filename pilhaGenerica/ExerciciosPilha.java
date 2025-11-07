package pilhaGenerica;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class ExerciciosPilha {

    /**
     * Implementação didática de uma Pilha (Stack) usando LinkedList internamente.
     * Métodos: push, pop, peek, isVazia, tamanho, imprimir.
     */
    public static class Pilha<T> {
        private LinkedList<T> dados = new LinkedList<>();

        // Insere no topo (início da lista para operações O(1))
        public void push(T valor) {
            dados.addFirst(valor);
        }

        // Remove e retorna o topo
        public T pop() {
            if (isVazia()) throw new NoSuchElementException("Pilha vazia");
            return dados.removeFirst();
        }

        // EXERCÍCIO 2: retorna o topo SEM remover
        public T peek() {
            if (isVazia()) throw new NoSuchElementException("Pilha vazia");
            return dados.getFirst();
        }

        public boolean isVazia() {
            return dados.isEmpty();
        }

        public int tamanho() {
            return dados.size();
        }

        public void imprimir() {
            // Exibe do topo para a base
            System.out.println("Topo -> " + dados);
        }
        
        // Adicionando um getter para a lista interna para o debug do Exercicio 5
        public LinkedList<T> getDados() {
            return dados;
        }
    }

    // =========================================================
    // EXERCÍCIO 1
    // Criar pilha de Strings, empilhar "Ana", "Bruno", "Carlos",
    // remover o topo e exibir o restante.
    // =========================================================
    public static void exercicio1() {
        System.out.println("==== EXERCÍCIO 1 ====");
        Pilha<String> pilhaNomes = new Pilha<>();

        // Empilhando (push) — o último inserido fica no topo
        pilhaNomes.push("Ana");
        pilhaNomes.push("Bruno");
        pilhaNomes.push("Carlos");

        System.out.print("Pilha após push: ");
        pilhaNomes.imprimir(); // Topo -> [Carlos, Bruno, Ana]

        // Remover topo (pop): deve remover "Carlos"
        String removido = pilhaNomes.pop();
        System.out.println("Removido (topo): " + removido);

        System.out.print("Pilha final: ");
        pilhaNomes.imprimir(); // Topo -> [Bruno, Ana]
        System.out.println();
    }

    // =========================================================
    // EXERCÍCIO 2
    // Implementar peek() na pilha (já implementado na classe Pilha)
    // e demonstrar que NÃO remove o topo.
    // =========================================================
    public static void exercicio2() {
        System.out.println("==== EXERCÍCIO 2 ====");
        Pilha<Integer> pilha = new Pilha<>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        System.out.print("Pilha atual: ");
        pilha.imprimir(); // Topo -> [30, 20, 10]

        int antes = pilha.tamanho();
        int topo = pilha.peek(); // NÃO remove
        int depois = pilha.tamanho();

        System.out.println("peek() retornou: " + topo + " (sem remover)");
        System.out.println("Tamanho antes: " + antes + " | depois: " + depois);
        System.out.print("Pilha permanece: ");
        pilha.imprimir();
        System.out.println();
    }

    // =========================================================
    // EXERCÍCIO 3
    // Usar uma pilha para inverter uma palavra (ex.: "JAVA" -> "AVAJ").
    // Estratégia: empilhar cada caractere e depois desempilhar concatenando.
    // =========================================================
    public static String inverterPalavraComPilha(String palavra) {
        Pilha<Character> pilha = new Pilha<>();
        // Empilha cada caractere
        for (char c : palavra.toCharArray()) {
            pilha.push(c);
        }
        // Desempilha formando a string invertida
        StringBuilder sb = new StringBuilder();
        while (!pilha.isVazia()) {
            sb.append(pilha.pop());
        }
        return sb.toString();
    }

    public static void exercicio3() {
        System.out.println("==== EXERCÍCIO 3 ====");
        String palavra = "JAVA";
        String invertida = inverterPalavraComPilha(palavra);
        System.out.println("Original:  " + palavra);
        System.out.println("Invertida: " + invertida); // AVAJ
        System.out.println();
    }

    // =========================================================
    // EXERCÍCIO 4
    // Verificar se uma expressão tem parênteses balanceados.
    // Regras simples:
    // - Para cada '(' encontrado, empilhe.
    // - Para cada ')', desempilhe; se não houver nada para desempilhar, está desbalanceada.
    // - Ao final, pilha deve estar vazia.
    // (Extensão opcional: lidar com {}, [])
    // =========================================================
    public static boolean parentesesBalanceados(String expr) {
        Pilha<Character> pilha = new Pilha<>();
        for (char c : expr.toCharArray()) {
            if (c == '(') {
                pilha.push(c);
            } else if (c == ')') {
                if (pilha.isVazia()) return false;
                pilha.pop();
            }
        }
        return pilha.isVazia();
    }

    public static void exercicio4() {
        System.out.println("==== EXERCÍCIO 4 ====");
        String e1 = "((2 + 3) * (4 - 1))";
        String e2 = ")(2 + 3)(";
        String e3 = "(1 + (2 * 3)";     // faltando fechar
        String e4 = "(1 + 2) * (3 + 4)"; // ok

        System.out.println(e1 + " -> " + (parentesesBalanceados(e1) ? "Balanceada" : "Desbalanceada"));
        System.out.println(e2 + " -> " + (parentesesBalanceados(e2) ? "Balanceada" : "Desbalanceada"));
        System.out.println(e3 + " -> " + (parentesesBalanceados(e3) ? "Balanceada" : "Desbalanceada"));
        System.out.println(e4 + " -> " + (parentesesBalanceados(e4) ? "Balanceada" : "Desbalanceada"));
        System.out.println();
    }

    // =========================================================
    // EXERCÍCIO 5
    // Simular histórico de navegador com "Voltar" usando pilhas.
    // - Duas pilhas: voltar (à esquerda) e avancar (à direita).
    // - visita(url): se houver atual, empilha em "voltar"; atual = url; limpa "avancar".
    // - voltar(): empilha atual em "avancar" e atual = pop(voltar).
    // - avancar(): empilha atual em "voltar" e atual = pop(avancar).
    // =========================================================
    public static class HistoricoNavegador {
        private Pilha<String> voltar = new Pilha<>();
        private Pilha<String> avancar = new Pilha<>();
        private String atual = null;

        public void visitar(String url) {
            if (atual != null) {
                voltar.push(atual);
            }
            atual = url;
            // novo caminho: limpar "avançar"
            while (!avancar.isVazia()) avancar.pop();
            System.out.println("Visitou: " + atual);
            debug();
        }

        public void voltar() {
            if (voltar.isVazia()) {
                System.out.println("Não há página para voltar.");
                return;
            }
            avancar.push(atual);
            atual = voltar.pop();
            System.out.println("Voltou para: " + atual);
            debug();
        }

        public void avancar() {
            if (avancar.isVazia()) {
                System.out.println("Não há página para avançar.");
                return;
            }
            voltar.push(atual);
            atual = avancar.pop();
            System.out.println("Avançou para: " + atual);
            debug();
        }

        public void debug() {
            // Acessando a lista interna através do getter
            System.out.println("Voltar:  " + (voltar.tamanho() == 0 ? "[]" : voltar.getDados()));
            System.out.println("Atual:   " + atual);
            System.out.println("Avançar: " + (avancar.tamanho() == 0 ? "[]" : avancar.getDados()));
            System.out.println();
        }
    }

    public static void exercicio5() {
        System.out.println("==== EXERCÍCIO 5 ====");
        HistoricoNavegador nav = new HistoricoNavegador();
        nav.visitar("https://faetec.rj.gov.br" );
        nav.visitar("https://www.oracle.com/java/" );
        nav.visitar("https://docs.oracle.com/en/java/" );
        nav.voltar();   // volta para oracle.com/java
        nav.voltar();   // volta para faetec
        nav.avancar();  // avança para oracle.com/java
        nav.visitar("https://openjdk.org/" ); // abre novo caminho (limpa avançar)
    }

    // MAIN: executa todos os exercícios
    public static void main(String[] args) {
        exercicio1();
        exercicio2();
        exercicio3();
        exercicio4();
        exercicio5();
    }
}
