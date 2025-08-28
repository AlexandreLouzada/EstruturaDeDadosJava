public class NumeroArray {
    private int[] numeros;

    public NumeroArray(int[] numeros) {
        this.numeros = numeros;
    }

    /** Retorna todas as posições (índices) onde 'valor' ocorre no array. */
    public int[] buscarOcorrencias(int valor) {
        int[] posicoesTemp = new int[numeros.length]; // array auxiliar
        int contador = 0;

        // Percorre o array e guarda índices encontrados
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == valor) {
                posicoesTemp[contador] = i;
                contador++;
            }
        }

        // Criar array final com tamanho exato das ocorrências
        int[] resultado = new int[contador];
        for (int i = 0; i < contador; i++) {
            resultado[i] = posicoesTemp[i];
        }
        return resultado;
    }

    public void imprimirArray() {
        System.out.print("Array: ");
        for (int n : numeros) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}