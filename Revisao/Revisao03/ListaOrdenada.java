public class ListaOrdenada {
    private class No {
        int valor;
        No proximo;

        No(int valor) {
            this.valor = valor;
        }
    }

    private No primeiro;

    // Insere o valor na posição correta para manter a ordem crescente
    public void inserirOrdenado(int valor) {
        No novo = new No(valor);

        if (primeiro == null || valor < primeiro.valor) {
            novo.proximo = primeiro;
            primeiro = novo;
        } else {
            No atual = primeiro;
            while (atual.proximo != null && atual.proximo.valor < valor) {
                atual = atual.proximo;
            }
            novo.proximo = atual.proximo;
            atual.proximo = novo;
        }
    }

    public void imprimir() {
        No atual = primeiro;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListaOrdenada lista = new ListaOrdenada();
        lista.inserirOrdenado(10);
        lista.inserirOrdenado(30);
        lista.inserirOrdenado(20);
        lista.inserirOrdenado(25);

        lista.imprimir();  // Saída esperada: 10 20 25 30
    }
}

