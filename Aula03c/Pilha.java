class Pilha {
    private int topo;
    private int[] elementos;
    private int capacidade;

    // Construtor para inicializar a pilha com uma capacidade específica
    public Pilha(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new int[capacidade];
        this.topo = -1; // Indica que a pilha está vazia
    }

    // Verifica se a pilha está vazia
    public boolean isEmpty() {
        return topo == -1;
    }

    // Verifica se a pilha está cheia
    public boolean isFull() {
        return topo == capacidade - 1;
    }

    // Método para empilhar um elemento (push)
    public void push(int elemento) {
        if (isFull()) {
            System.out.println("Erro: Pilha cheia!");
            return;
        }
        elementos[++topo] = elemento;
    }

    // Método para desempilhar um elemento (pop)
    public int pop() {
        if (isEmpty()) {
            System.out.println("Erro: Pilha vazia!");
            return -1;
        }
        return elementos[topo--];
    }

    // Método para visualizar o topo da pilha (peek)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Erro: Pilha vazia!");
            return -1;
        }
        return elementos[topo];
    }

    // Método para imprimir a pilha
    public void imprimirPilha() {
        if (isEmpty()) {
            System.out.println("A pilha está vazia.");
            return;
        }
        System.out.print("Pilha: ");
        for (int i = 0; i <= topo; i++) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println();
    }
}

