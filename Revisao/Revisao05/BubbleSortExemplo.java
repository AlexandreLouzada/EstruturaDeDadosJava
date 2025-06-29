public class BubbleSortExemplo {

    public static void bubbleSort(int[] array) {
        int n = array.length;
        int passo = 1;

        for (int i = 0; i < n - 1; i++) {
            System.out.println("Passo " + passo + ":");
            for (int j = 0; j < n - 1 - i; j++) {
                System.out.print("Comparando " + array[j] + " e " + array[j + 1]);
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    System.out.println(" -> troca realizada");
                } else {
                    System.out.println(" -> sem troca");
                }
            }
            passo++;
        }
    }

    public static void main(String[] args) {
        int[] numeros = {5, 3, 8, 4, 2};
        System.out.println("Vetor original:");
        for (int num : numeros) System.out.print(num + " ");
        System.out.println("\n");

        bubbleSort(numeros);

        System.out.println("\nVetor ordenado:");
        for (int num : numeros) System.out.print(num + " ");
    }
}
