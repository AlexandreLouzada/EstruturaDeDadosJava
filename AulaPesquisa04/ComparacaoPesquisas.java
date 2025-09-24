package aulaPesquisa04;

import java.util.Arrays;

public class ComparacaoPesquisas {

    // Pesquisa Linear
    public static int buscaLinear(int[] array, int chave) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == chave) {
                return i; // Retorna a posição se encontrar
            }
        }
        return -1; // Não encontrou
    }

    // Pesquisa Binária
    public static int buscaBinaria(int[] array, int chave) {
        int inicio = 0;
        int fim = array.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (array[meio] == chave) {
                return meio;
            } else if (array[meio] < chave) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Criando um array de 100.000 elementos ordenados
        int tamanho = 100_000;
        int[] numeros = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            numeros[i] = i; // Array contém [0, 1, 2, 3, ..., 99999]
        }

        // Definindo a chave que queremos procurar
        int chave = 99_999; // último elemento -> pior caso da pesquisa linear

        // ---- TESTE PESQUISA LINEAR ----
        long inicioLinear = System.currentTimeMillis(); // tempo inicial
        int resultadoLinear = buscaLinear(numeros, chave);
        long fimLinear = System.currentTimeMillis();   // tempo final
        long tempoLinear = fimLinear - inicioLinear;   // tempo total

        // ---- TESTE PESQUISA BINÁRIA ----
        long inicioBinaria = System.currentTimeMillis();
        int resultadoBinaria = buscaBinaria(numeros, chave);
        long fimBinaria = System.currentTimeMillis();
        long tempoBinaria = fimBinaria - inicioBinaria;

        // ---- RESULTADOS ----
        System.out.println("Resultado pesquisa linear: " + resultadoLinear);
        System.out.println("Tempo pesquisa linear: " + tempoLinear + " ms");

        System.out.println("Resultado pesquisa binária: " + resultadoBinaria);
        System.out.println("Tempo pesquisa binária: " + tempoBinaria + " ms");
    }
}

