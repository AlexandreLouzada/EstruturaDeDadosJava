package projetoArray04.view;

import projetoArray04.model.Paciente;
import projetoArray04.service.FilaPrioridadeService;

import java.util.Scanner;

public class MenuAtendimento {
    private final Scanner sc = new Scanner(System.in);
    private FilaPrioridadeService fila;

    public void iniciar() {
        int capacidade = lerInt("Quantos pacientes deseja cadastrar? ");
        fila = new FilaPrioridadeService(capacidade);

        for (int i = 0; i < capacidade; i++) {
            System.out.println("\nCadastro do paciente " + (i + 1));
            String nome = lerTexto("Nome: ");
            int id = lerInt("ID: ");
            int idade = lerInt("Idade: ");
            int espera = lerInt("Tempo de espera (min): ");
            int urgencia = lerInt("Nível de urgência (1-5): ");

            Paciente p = new Paciente(nome, id, idade, espera, urgencia);
            fila.inserir(p);
        }

        int op;
        do {
            menu();
            op = lerInt("Escolha: ");
            executar(op);
        } while (op != 0);
    }

    private void menu() {
        System.out.println("\n===== MENU ATENDIMENTO =====");
        System.out.println("1 - Ver próximo da fila");
        System.out.println("2 - Buscar por nome");
        System.out.println("3 - Exibir toda a fila");
        System.out.println("0 - Sair");
    }

    private void executar(int op) {
        switch (op) {
            case 1 -> {
                Paciente p = fila.proximo();
                if (p != null)
                    System.out.println("➡ Próximo a ser atendido: " + p);
                else
                    System.out.println("Fila vazia.");
            }
            case 2 -> {
                String nome = lerTexto("Nome para buscar: ");
                Paciente p = fila.buscarPorNome(nome);
                System.out.println(p != null ? p : "Paciente não encontrado.");
            }
            case 3 -> {
                System.out.println("\nFila de atendimento:");
                fila.exibirFila();
            }
            case 0 -> System.out.println("Encerrando...");
            default -> System.out.println("Opção inválida.");
        }
    }

    private int lerInt(String msg) {
        System.out.print(msg);
        while (!sc.hasNextInt()) {
            System.out.print("Valor inválido. " + msg);
            sc.next();
        }
        int val = sc.nextInt(); sc.nextLine();
        return val;
    }

    private String lerTexto(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }
}

