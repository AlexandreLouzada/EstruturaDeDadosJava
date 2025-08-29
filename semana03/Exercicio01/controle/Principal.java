import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] vetor = new int[10];

        System.out.println("Digite 20 números inteiros:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            vetor[i] = scanner.nextInt();
        }

        // Criando objeto da classe NumeroArray
        NumeroArray numArray = new NumeroArray(vetor);

        // Imprimir array
        numArray.imprimirArray();

        // Contar pares e ímpares
        numArray.contarParesEImpares();

        scanner.close();
    }
}