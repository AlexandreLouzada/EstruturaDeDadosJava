package aulaPesquisa06;

public class PesquisaLinearStrings {
    /**
     * Busca linear em um array de Strings (ignora maiúsculas/minúsculas).
     * 
     * @param nomes array de nomes
     * @param chave nome a ser procurado
     * @return índice onde a chave foi encontrada ou -1 se não existir
     */
    public static int buscarLinear(String[] nomes, String chave) {
        for (int indice = 0; indice < nomes.length; indice++) {
            // equalsIgnoreCase permite "ana" == "Ana"
            if (nomes[indice].equalsIgnoreCase(chave)) {
                return indice;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] alunos = {"Ana", "Bruno", "Carlos", "Daniela", "Eduardo", "ana"};
        int pos = buscarLinear(alunos, "ANA"); // deve encontrar a primeira ocorrência (índice 0)
        System.out.println("Resultado: " + pos);
    }
}
