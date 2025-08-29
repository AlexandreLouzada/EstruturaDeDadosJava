import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] vetor = new int[5];
        System.out.println("Digite 10 números inteiros:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            vetor[i] = scanner.nextInt();
        }

        NumeroArray numArray = new NumeroArray(vetor);
        numArray.imprimirArray();

        System.out.print("Digite um número para buscar no array: ");
        int busca = scanner.nextInt();

        int[] posicoes = numArray.buscarOcorrencias(busca);

        if (posicoes.length == 0) {
            System.out.println("O número " + busca + " NÃO foi encontrado no array.");
        } else {
            System.out.print("O número " + busca + " foi encontrado nas posições (índices): ");
            for (int i = 0; i < posicoes.length; i++) {
                System.out.print(posicoes[i]);
                if (i < posicoes.length - 1) System.out.print(", ");
            }
            System.out.println();
        }

        scanner.close();
    }
}