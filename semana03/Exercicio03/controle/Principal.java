import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] vetor = new String[10];

        System.out.println("Digite 10 nomes:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Nome " + (i + 1) + ": ");
            vetor[i] = scanner.nextLine();
        }

        NomeArray nomeArray = new NomeArray(vetor);
        nomeArray.imprimirArray();

        System.out.print("Digite um nome para remover TODAS as ocorrências: ");
        String nomeRemover = scanner.nextLine();

        int removidos = nomeArray.removerNome(nomeRemover);

        if (removidos > 0) {
            System.out.println("O nome \"" + nomeRemover + "\" foi removido " + removidos + " vez(es).");
        } else {
            System.out.println("O nome \"" + nomeRemover + "\" não foi encontrado no array.");
        }

        // Exibe o array após remoções
        nomeArray.imprimirArray();

        scanner.close();
    }
}