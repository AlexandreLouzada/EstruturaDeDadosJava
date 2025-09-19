package aulaPesquisa05;

public class PesquisaLinearInteiros {
    /**
     * Busca linear em um array de inteiros.
     * 
     * @param dados array onde vamos procurar
     * @param chave valor que queremos encontrar
     * @return índice onde a chave foi encontrada ou -1 se não existir
     * 
     */
    public static int buscarLinear(int[] dados, int chave) {
        // Percorre todas as posições do array, da primeira (0) à última (dados.length
        // -1)
        for (int indice = 0; indice < dados.length; indice++) {
            // Compara o elemento atual com a chave
            if (dados[indice] == chave) {
                // Se for igual, retornamos a posição (índice) e encerramos o método
                return indice;
            }
        }
        // Se o laço terminar, a chave não está no array
        return -1;
    }

    public static void main(String[] args) {
        // Exemplo simples: array pequeno
        int[] numeros = { 34, 56, 2, 10, 77, 51, 93, 30, 5, 52 };
        int chave1 = 51; // existe no array
        int chave2 = 99; // não existe
        int posicao1 = buscarLinear(numeros, chave1);
        int posicao2 = buscarLinear(numeros, chave2);
        if (posicao1 != -1) {
            System.out.println("Chave " + chave1 + " encontrada na posição: " +
                    posicao1);
        } else {
            System.out.println("Chave " + chave1 + " não encontrada.");
        }
        if (posicao2 != -1) {
            System.out.println("Chave " + chave2 + " encontrada na posição: " +
                    posicao2);
        } else {
            System.out.println("Chave " + chave2 + " não encontrada.");
        }
    }
}
