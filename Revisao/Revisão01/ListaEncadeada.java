public class ListaEncadeada<T> {
    private class No {
        T valor;
        No proximo;

        No(T valor) {
            this.valor = valor;
        }
    }

    private No primeiro;
    private No ultimo;

    public void inserirFinal(T valor) {
        No novo = new No(valor);
        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.proximo = novo;
            ultimo = novo;
        }
    }

    public void imprimirLista() {
        No atual = primeiro;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public T obterUltimoValor() {
        return (ultimo != null) ? ultimo.valor : null;
    }

    public static void main(String[] args) {
        ListaEncadeada<String> lista = new ListaEncadeada<>();
        lista.inserirFinal("A");
        lista.inserirFinal("B");
        lista.imprimirLista(); // Esperado: A B
        System.out.println("Valor do último nó: " + lista.obterUltimoValor()); // Esperado: B
    }
}
