class ListaArrayString {
    private String[] array;
    private int tamanho;

    // Construtor que inicializa a lista com uma capacidade específica
    public ListaArrayString(int capacidade) {
        this.array = new String[capacidade];
        this.tamanho = 0;
    }

    // Método para adicionar um nome ao final da lista
    public void adicionar(String elemento) {
        if (tamanho == array.length) {
            System.out.println("Erro: Lista cheia!");
            return;
        }
        array[tamanho++] = elemento;
    }

    // Método para remover um nome de uma posição específica
    public void remover(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            System.out.println("Erro: Posição inválida!");
            return;
        }
        for (int i = posicao; i < tamanho - 1; i++) {
            array[i] = array[i + 1];
        }
        tamanho--;
    }

    // Método para buscar um nome na lista e retornar sua posição
    public int buscar(String nome) {
        for (int i = 0; i < tamanho; i++) {
            if (array[i].equals(nome)) {
                return i;
            }
        }
        return -1; // Retorna -1 caso o nome não seja encontrado
    }

    // Método para imprimir todos os nomes da lista
    public void imprimirLista() {
        if (tamanho == 0) {
            System.out.println("Lista vazia.");
            return;
        }
        System.out.print("Lista de Nomes: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

