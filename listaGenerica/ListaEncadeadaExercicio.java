package listaGenerica;

import java.util.NoSuchElementException;
import java.util.Arrays;

public class ListaEncadeadaExercicio {

    /*
     * Implementação didática de uma lista encadeada simples (genérica) em Java
     * + Demonstração dos exercícios 1 a 5.
     */

    /*
     * Classe de nó (autorreferencial): armazena o dado e a referência para o
     * próximo nó.
     */
    private static class Nodo<T> {
        T dado; // valor armazenado no nó
        Nodo<T> proximo; // referência para o próximo nó

        Nodo(T dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }

    /*
     * Lista encadeada genérica com operações pedidas nos exercícios.
     */
    public static class ListaEncadeada<T> {
        private Nodo<T> primeiro; // referência para o primeiro nó
        private Nodo<T> ultimo; // referência para o último nó (para inserção rápida no fim)

        public ListaEncadeada() {
            this.primeiro = null;
            this.ultimo = null;
        }

        /**
         * EX.1: inserir no início (insertAtFront)
         * Passos:
         * 1) Criar novo nó apontando para o antigo primeiro.
         * 2) Atualizar o primeiro.
         * 3) Se a lista estava vazia, o último também passa a ser o novo nó.
         */
        public void inserirNoInicio(T valor) {
            Nodo<T> novo = new Nodo<>(valor);
            novo.proximo = primeiro;
            primeiro = novo;
            if (ultimo == null) {
                ultimo = novo;
            }
        }

        /**
         * EX.1: inserir no fim (insertAtBack)
         * Passos:
         * 1) Se a lista estiver vazia, primeiro = último = novo nó.
         * 2) Caso contrário, último.proximo = novo e atualiza último.
         */
        public void inserirNoFim(T valor) {
            Nodo<T> novo = new Nodo<>(valor);
            if (estaVazia()) {
                primeiro = ultimo = novo;
            } else {
                ultimo.proximo = novo;
                ultimo = novo;
            }
        }

        /**
         * EX.1: imprimir a lista (print)
         * Percorre do primeiro até null, exibindo os dados em sequência.
         */
        public void imprimir() {
            if (estaVazia()) {
                System.out.println("Lista vazia");
                return;
            }
            StringBuilder sb = new StringBuilder();
            Nodo<T> atual = primeiro;
            while (atual != null) {
                sb.append(atual.dado);
                if (atual.proximo != null)
                    sb.append(" -> ");
                atual = atual.proximo;
            }
            System.out.println(sb.toString());
        }

        /**
         * EX.2: contar elementos (tamanho da lista)
         */
        public int contar() {
            int cont = 0;
            Nodo<T> atual = primeiro;
            while (atual != null) {
                cont++;
                atual = atual.proximo;
            }
            return cont;
        }

        /**
         * EX.3: remover a primeira ocorrência de um valor
         * Regras:
         * - Se a lista estiver vazia, retorna false.
         * - Se o primeiro nó for o que procuramos, avança o "primeiro".
         * - Senão, percorre mantendo referência ao anterior para "pular" o nó
         * encontrado.
         */
        public boolean removerPrimeiraOcorrencia(T valor) {
            if (estaVazia())
                return false;

            // Caso especial: o primeiro é o que queremos remover
            if (igual(primeiro.dado, valor)) {
                primeiro = primeiro.proximo;
                if (primeiro == null) { // se esvaziou a lista, atualiza último
                    ultimo = null;
                }
                return true;
            }

            // Percorre procurando o valor, mantendo referência ao anterior
            Nodo<T> anterior = primeiro;
            Nodo<T> atual = primeiro.proximo;

            while (atual != null) {
                if (igual(atual.dado, valor)) {
                    anterior.proximo = atual.proximo;
                    if (atual == ultimo) { // se removi o último, preciso atualizar o ponteiro "ultimo"
                        ultimo = anterior;
                    }
                    return true;
                }
                anterior = atual;
                atual = atual.proximo;
            }

            return false; // não encontrou
        }

        // Função utilitária para comparar (considera nulls)
        private boolean igual(T a, T b) {
            if (a == b)
                return true;
            if (a == null || b == null)
                return false;
            return a.equals(b);
        }

        /**
         * EX.5: converter a lista para um array de Object (forma simples)
         * Observação: por questões de tipos genéricos em Java, o retorno é Object[].
         * O usuário pode fazer cast ao tipo desejado se souber o tipo dos elementos.
         */
        public Object[] paraArray() {
            Object[] arr = new Object[contar()];
            int i = 0;
            Nodo<T> atual = primeiro;
            while (atual != null) {
                arr[i++] = atual.dado;
                atual = atual.proximo;
            }
            return arr;
        }

        /**
         * Remover do início (utilizado em exemplos e testes)
         */
        public T removerDoInicio() {
            if (estaVazia())
                throw new NoSuchElementException("Lista vazia");
            T valor = primeiro.dado;
            primeiro = primeiro.proximo;
            if (primeiro == null) {
                ultimo = null;
            }
            return valor;
        }

        /**
         * Remover do fim (utilizado em exemplos e testes)
         * Percorre até o penúltimo para ajustar "ultimo".
         */
        public T removerDoFim() {
            if (estaVazia())
                throw new NoSuchElementException("Lista vazia");

            if (primeiro == ultimo) { // só 1 elemento
                T valor = primeiro.dado;
                primeiro = ultimo = null;
                return valor;
            }

            // percorre até o penúltimo
            Nodo<T> atual = primeiro;
            while (atual.proximo != ultimo) {
                atual = atual.proximo;
            }
            T valor = ultimo.dado;
            atual.proximo = null;
            ultimo = atual;
            return valor;
        }

        public boolean estaVazia() {
            return primeiro == null;
        }
    }

    // ============================
    // DEMONSTRAÇÃO: Exercícios 1 a 5
    // ============================
    public static void main(String[] args) {
        System.out.println(
                "==== EXERCÍCIO 1: criar lista de inteiros e implementar inserirNoInicio, inserirNoFim e imprimir ====");
        ListaEncadeada<Integer> lista1 = new ListaEncadeada<>();
        lista1.inserirNoInicio(3);
        lista1.inserirNoInicio(2);
        lista1.inserirNoInicio(1); // lista: 1 -> 2 -> 3
        lista1.inserirNoFim(4);
        lista1.inserirNoFim(5); // lista: 1 -> 2 -> 3 -> 4 -> 5
        System.out.print("Lista 1: ");
        lista1.imprimir();

        System.out.println("\n==== EXERCÍCIO 2: contar elementos da lista ====");
        int qtd = lista1.contar();
        System.out.println("Quantidade de elementos em lista1: " + qtd); // esperado: 5

        System.out.println("\n==== EXERCÍCIO 3: remover primeira ocorrência de um valor ====");
        boolean r1 = lista1.removerPrimeiraOcorrencia(3); // remove o "3" do meio
        System.out.println("Removeu 3? " + r1);
        System.out.print("Lista 1 após remover 3: ");
        lista1.imprimir(); // esperado: 1 -> 2 -> 4 -> 5

        boolean r2 = lista1.removerPrimeiraOcorrencia(1); // remove o primeiro
        System.out.println("Removeu 1? " + r2);
        System.out.print("Lista 1 após remover 1: ");
        lista1.imprimir(); // esperado: 2 -> 4 -> 5

        boolean r3 = lista1.removerPrimeiraOcorrencia(99); // não existe
        System.out.println("Tentou remover 99? " + r3);
        System.out.print("Lista 1 final: ");
        lista1.imprimir();

        System.out.println("\n==== EXERCÍCIO 4: lista encadeada de nomes (Strings) ====");
        ListaEncadeada<String> chamada = new ListaEncadeada<>();
        chamada.inserirNoFim("Ana");
        chamada.inserirNoFim("Carlos");
        chamada.inserirNoFim("Bianca");
        chamada.inserirNoInicio("João"); // João chega e entra no início
        System.out.print("Chamada: ");
        chamada.imprimir(); // esperado: João -> Ana -> Carlos -> Bianca

        // Remover uma ocorrência específica (ex.: saiu "Carlos")
        boolean removidoCarlos = chamada.removerPrimeiraOcorrencia("Carlos");
        System.out.println("Removeu Carlos? " + removidoCarlos);
        System.out.print("Chamada após remover Carlos: ");
        chamada.imprimir(); // esperado: João -> Ana -> Bianca

        System.out.println("\n==== EXERCÍCIO 5: converter lista para array ====");
        Object[] arr = chamada.paraArray();
        System.out.println("Array resultante: " + Arrays.toString(arr)); // esperado: [João, Ana, Bianca]
    }
}
