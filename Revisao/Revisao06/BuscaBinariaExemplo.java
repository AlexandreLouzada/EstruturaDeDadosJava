public class BuscaBinariaExemplo {

    public static int buscaBinaria(int[] vetor, int chave) {
        int inicio = 0;
        int fim = vetor.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            System.out.println("Verificando posição " + meio + ": valor = " + vetor[meio]);

            if (vetor[meio] == chave) {
                return meio; // Encontrou o valor
            } else if (vetor[meio] < chave) {
                inicio = meio + 1; // Descartar a metade esquerda
            } else {
                fim = meio - 1; // Descartar a metade direita
            }
        }

        return -1; // Valor não encontrado
    }

    public static void main(String[] args) {
        int[] vetor = {2, 4, 6, 8, 10, 12, 14};
        int valorBuscado = 10;

        int posicao = buscaBinaria(vetor, valorBuscado);

        if (posicao != -1) {
            System.out.println("Valor " + valorBuscado + " encontrado na posição " + posicao + ".");
        } else {
            System.out.println("Valor não encontrado.");
        }
    }
}
