public class SelectionSortExemplo {

    public static int selectionSort(int[] vetor) {
        int trocas = 0;

        for (int i = 0; i < vetor.length - 1; i++) {
            int menorIndice = i;

            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[menorIndice]) {
                    menorIndice = j;
                }
            }

            if (menorIndice != i) {
                int temp = vetor[i];
                vetor[i] = vetor[menorIndice];
                vetor[menorIndice] = temp;
                trocas++;
            }
        }

        return trocas;
    }

    public static void main(String[] args) {
        int[] numeros = {64, 25, 12, 22, 11};
        int totalTrocas = selectionSort(numeros);

        System.out.print("Vetor ordenado: ");
        for (int num : numeros) {
            System.out.print(num + " ");
        }

        System.out.println("\nTotal de trocas realizadas: " + totalTrocas);
    }
}
