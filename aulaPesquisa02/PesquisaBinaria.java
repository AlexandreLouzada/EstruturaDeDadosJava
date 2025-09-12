package aulaPesquisa02;

public class PesquisaBinaria {
    // Método que implementa a busca binária
    public static int buscaBinaria(int[] array, int chave) {
        int inicio = 0; // Início do intervalo
        int fim = array.length - 1; // Fim do intervalo
        // Enquanto ainda houver elementos para pesquisar
        while (inicio <= fim) {
            // Calcula o índice do meio
            int meio = (inicio + fim) / 2;
            // Se o elemento do meio é igual à chave, encontramos
            if (array[meio] == chave) {
                return meio;
            }
            // Se a chave é maior, pesquisa na metade direita
            else if (array[meio] < chave) {
                inicio = meio + 1;
            }
            // Caso contrário, pesquisa na metade esquerda
            else {
                fim = meio - 1;
            }
        }
        // Se saiu do laço, o elemento não está no array
        return -1;
    }

    public static void main(String[] args) {
        // Array precisa estar ORDENADO para a busca binária funcionar
        int[] numeros = {10,20,30,40,50,60,70,80};
        // Elemento que queremos procurar
        int chave = 70;
        // Chamada da busca binária
        int posicao = buscaBinaria(numeros, chave);
        // Exibição do resultado
        if (posicao != -1) {
            System.out.println("Elemento encontrado na posição: " + posicao);
        } else {
            System.out.println("Elemento não encontrado.");
        }
    }
}
