package aulaPesquisa03;

public class PesquisaLinearString {

    // Método que recebe um array de Strings e o nome a ser pesquisado
    public static int buscaLinear(String[] nomes, String chave) {
        // Percorre cada posição do array
        for (int i = 0; i < nomes.length; i++) {
            // Usa equalsIgnoreCase para comparar sem diferenciar maiúsculas/minúsculas
            if (nomes[i].equalsIgnoreCase(chave)) {
                return i; // retorna a posição onde o nome foi encontrado
            }
        }
        // Se chegou até aqui, o nome não existe no array
        return -1;
    }

    public static void main(String[] args) {
        // Definindo um array de Strings com alguns nomes
        String[] alunos = {"Ana", "Bruno", "Carlos", "Daniela", "Eduardo"};

        // Nome que queremos procurar
        String chave = "Daniela";

        // Chamando o método de pesquisa linear
        int posicao = buscaLinear(alunos, chave);

        // Exibindo o resultado da pesquisa
        if (posicao != -1) {
            System.out.println("Nome encontrado na posição: " + posicao);
        } else {
            System.out.println("Nome não encontrado na lista.");
        }
    }
}

