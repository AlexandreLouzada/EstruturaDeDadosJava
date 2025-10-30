package aulaLinkedList02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FilaBanco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<String> fila = new LinkedList<>();
        int opcao;

        do {
            System.out.println("\n=== Sistema de Atendimento do Banco ===");
            System.out.println("1 - Adicionar cliente na fila");
            System.out.println("2 - Atender cliente");
            System.out.println("3 - Mostrar fila atual");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String cliente = scanner.nextLine();
                    fila.add(cliente);
                    System.out.println(cliente + " entrou na fila.");
                    break;
                case 2:
                    if (!fila.isEmpty()) {
                        String atendido = fila.poll();
                        System.out.println("Atendendo: " + atendido);
                    } else {
                        System.out.println("A fila está vazia!");
                    }
                    break;
                case 3:
                    System.out.println("Fila atual: " + fila);
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
