package filaGenerica;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class ExerciciosFila {

    /**
     * Implementação didática de uma Fila (Queue) usando LinkedList internamente.
     * Operações:
     *  - enqueue: insere no FIM (regra FIFO)
     *  - dequeue: remove do INÍCIO
     *  - peek: visualiza o próximo sem remover
     *  - isEmpty / size / print
     */
    public static class Fila<T> {
        private LinkedList<T> dados = new LinkedList<>();

        // Insere no final da fila (enqueue)
        public void enqueue(T valor) {
            dados.addLast(valor);
        }

        // Remove e retorna o primeiro da fila (dequeue)
        public T dequeue() {
            if (isEmpty()) throw new NoSuchElementException("Fila vazia");
            return dados.removeFirst();
        }

        // Retorna o próximo da fila SEM remover
        public T peek() {
            if (isEmpty()) throw new NoSuchElementException("Fila vazia");
            return dados.getFirst();
        }

        public boolean isEmpty() {
            return dados.isEmpty();
        }

        public int size() {
            return dados.size();
        }

        // Exibe a fila da esquerda (início) para a direita (fim)
        public void print() {
            System.out.println("Início -> " + dados + " <- Fim");
        }
    }

    // =========================================================
    // EXERCÍCIO 1
    // Criar uma fila de inteiros:
    // - Adicionar: 10, 20, 30, 40
    // - Remover dois elementos
    // - Exibir os restantes
    // =========================================================
    public static void exercicio1() {
        System.out.println("==== EXERCÍCIO 1 ====");
        Fila<Integer> fila = new Fila<>();
        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(30);
        fila.enqueue(40);

        System.out.print("Fila inicial: ");
        fila.print(); // [10, 20, 30, 40]

        System.out.println("Removido: " + fila.dequeue()); // 10
        System.out.println("Removido: " + fila.dequeue()); // 20

        System.out.print("Fila restante: ");
        fila.print(); // [30, 40]
        System.out.println();
    }

    // =========================================================
    // EXERCÍCIO 2
    // Fila de atendimento de banco:
    // - Clientes: Ana, João, Beatriz
    // - Remover o primeiro
    // - Adicionar Marcos
    // - Exibir resultado
    // =========================================================
    public static void exercicio2() {
        System.out.println("==== EXERCÍCIO 2 ====");
        Fila<String> fila = new Fila<>();
        fila.enqueue("Ana");
        fila.enqueue("João");
        fila.enqueue("Beatriz");

        System.out.print("Fila: ");
        fila.print(); // Ana, João, Beatriz

        System.out.println("Atendido: " + fila.dequeue()); // Ana

        fila.enqueue("Marcos");
        System.out.print("Fila final: ");
        fila.print(); // João, Beatriz, Marcos
        System.out.println();
    }

    // =========================================================
    // EXERCÍCIO 3
    // Simular fila de impressão:
    // - Adicionar Doc1, Doc2, Doc3
    // - "Imprimir" (remover) dois
    // - Adicionar Doc4
    // - Exibir a fila
    // =========================================================
    public static void exercicio3() {
        System.out.println("==== EXERCÍCIO 3 ====");
        Fila<String> spool = new Fila<>();
        spool.enqueue("Doc1");
        spool.enqueue("Doc2");
        spool.enqueue("Doc3");

        System.out.print("Spool inicial: ");
        spool.print();

        System.out.println("Imprimindo: " + spool.dequeue()); // Doc1
        System.out.println("Imprimindo: " + spool.dequeue()); // Doc2

        spool.enqueue("Doc4");
        System.out.print("Spool final: ");
        spool.print(); // Doc3, Doc4
        System.out.println();
    }

    // =========================================================
    // EXERCÍCIO 4
    // Criar um método peek() na fila (já implementado acima)
    // Demonstração: ver o próximo a ser atendido sem removê-lo
    // =========================================================
    public static void exercicio4() {
        System.out.println("==== EXERCÍCIO 4 ====");
        Fila<String> fila = new Fila<>();
        fila.enqueue("Cliente 1");
        fila.enqueue("Cliente 2");
        fila.enqueue("Cliente 3");

        System.out.print("Fila atual: ");
        fila.print();

        String proximo = fila.peek(); // NÃO remove
        System.out.println("Próximo a ser atendido (peek): " + proximo);

        System.out.print("Fila permanece: ");
        fila.print(); // deve estar igual
        System.out.println();
    }

    // =========================================================
    // EXERCÍCIO 5
    // Usar fila para percorrer números:
    // - Preencher com 1..5
    // - Remover todos, exibindo cada remoção
    // - Mostrar passo a passo
    // =========================================================
    public static void exercicio5() {
        System.out.println("==== EXERCÍCIO 5 ====");
        Fila<Integer> fila = new Fila<>();
        for (int i = 1; i <= 5; i++) {
            fila.enqueue(i);
            System.out.print("Após enqueue(" + i + "): ");
            fila.print();
        }

        while (!fila.isEmpty()) {
            int x = fila.dequeue();
            System.out.println("Dequeue -> " + x);
            System.out.print("Fila agora: ");
            fila.print();
        }
        System.out.println();
    }

    // MAIN: executa os exercícios 1..5
    public static void main(String[] args) {
        exercicio1();
        exercicio2();
        exercicio3();
        exercicio4();
        exercicio5();
    }
}
