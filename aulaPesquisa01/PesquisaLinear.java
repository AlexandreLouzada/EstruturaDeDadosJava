public class PesquisaLinear {
    // Método que recebe um array e a chave a ser pesquisada
    public static int buscaLinear(int[] array, int chave) {
        // Percorre o array do início até o final
        for (int i = 0; i < array.length; i++) {
            // Compara cada elemento com a chave
            if (array[i] == chave) {
                return i; // Retorna a posição onde encontrou
            }
        }
        return -1; // Se não encontrou, retorna -1
    }

    public static void main(String[] args) {
        // Definição de um array de inteiros
        int[] numeros = { 100, 80, 200, 35, 70, 150, 12,55 };
        // Definição da chave que queremos procurar
        int chave = 70;
        // Chamada do método de busca linear
        int posicao = buscaLinear(numeros, chave);
        // Exibição do resultado
        if (posicao != -1) {
            System.out.println("Elemento encontrado na posição: " + posicao);
        } else {
            System.out.println("Elemento não encontrado.");
        }
    }
}
