package aulaLinkedList03;

import java.util.Scanner;
import java.util.Stack;

public class NavegadorPilha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<String> voltar = new Stack<>();
        Stack<String> avancar = new Stack<>();
        String atual = null;

        int op;
        do {
            System.out.println("\n=== Navegador ===");
            System.out.println("1 - Visitar URL");
            System.out.println("2 - Voltar");
            System.out.println("3 - Avançar");
            System.out.println("4 - Página atual");
            System.out.println("5 - Debug (mostrar pilhas)");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            op = Integer.parseInt(sc.nextLine().trim());

            switch (op) {
                case 1 -> {
                    System.out.print("Digite a URL: ");
                    String url = sc.nextLine().trim();
                    if (atual != null) voltar.push(atual);
                    atual = url;
                    avancar.clear();
                    System.out.println("Visitou: " + atual);
                }
                case 2 -> {
                    if (voltar.isEmpty()) {
                        System.out.println("Não há página para voltar.");
                    } else {
                        avancar.push(atual);
                        atual = voltar.pop();
                        System.out.println("Voltou para: " + atual);
                    }
                }
                case 3 -> {
                    if (avancar.isEmpty()) {
                        System.out.println("Não há página para avançar.");
                    } else {
                        voltar.push(atual);
                        atual = avancar.pop();
                        System.out.println("Avançou para: " + atual);
                    }
                }
                case 4 -> System.out.println("Atual: " + (atual == null ? "(sem página)" : atual));
                case 5 -> {
                    System.out.println("Voltar:  " + voltar);
                    System.out.println("Atual:   " + atual);
                    System.out.println("Avançar: " + avancar);
                }
                case 0 -> System.out.println("Encerrando…");
                default -> {}
            }
        } while (op != 0);

        sc.close();
    }
}
