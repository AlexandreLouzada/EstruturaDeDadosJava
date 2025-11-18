package projetoArray01.view;

import projetoArray01.model.Produto;
import projetoArray01.service.EstoqueService;

import java.util.Scanner;

public class MenuEstoque {

    private Produto[] produtos;
    private EstoqueService service;
    private final Scanner sc = new Scanner(System.in);

    public void iniciar() {
        System.out.println("Cadastro de produtos no estoque");
        int total = lerInt("Quantos produtos deseja cadastrar? ");
        produtos = new Produto[total];

        for (int i = 0; i < total; i++) {
            System.out.println("\nProduto " + (i + 1));
            int id = lerInt("ID: ");
            String nome = lerTexto("Nome: ");
            int qtd = lerInt("Quantidade: ");
            double valor = lerDouble("Valor unitário: ");
            produtos[i] = new Produto(id, nome, qtd, valor);
        }

        service = new EstoqueService(produtos);

        int opcao;
        do {
            exibirMenu();
            opcao = lerInt("Escolha uma opção: ");
            processar(opcao);
        } while (opcao != 0);
    }

    private void exibirMenu() {
        System.out.println("\n===== MENU ESTOQUE =====");
        System.out.println("1 - Listar todos os produtos");
        System.out.println("2 - Buscar por ID");
        System.out.println("3 - Buscar por Nome");
        System.out.println("4 - Buscar todas as ocorrências por Nome");
        System.out.println("0 - Sair");
    }

    private void processar(int opcao) {
        switch (opcao) {
            case 1 -> service.listarTodos();
            case 2 -> {
                int id = lerInt("Informe o ID: ");
                Produto p = service.buscarPorId(id);
                System.out.println(p != null ? p : "Produto não encontrado.");
            }
            case 3 -> {
                String nome = lerTexto("Informe o nome: ");
                Produto p = service.buscarPorNome(nome);
                System.out.println(p != null ? p : "Produto não encontrado.");
            }
            case 4 -> {
                String nome = lerTexto("Informe o nome: ");
                Produto[] encontrados = service.buscarTodasOcorrenciasPorNome(nome);
                if (encontrados.length == 0) {
                    System.out.println("Nenhuma ocorrência encontrada.");
                } else {
                    for (Produto p : encontrados) {
                        System.out.println(p);
                    }
                }
            }
            case 0 -> System.out.println("Encerrando o programa.");
            default -> System.out.println("Opção inválida!");
        }
    }

    private int lerInt(String msg) {
        System.out.print(msg);
        while (!sc.hasNextInt()) {
            System.out.print("Valor inválido. " + msg);
            sc.next();
        }
        int val = sc.nextInt();
        sc.nextLine();
        return val;
    }

    private double lerDouble(String msg) {
        System.out.print(msg);
        while (!sc.hasNextDouble()) {
            System.out.print("Valor inválido. " + msg);
            sc.next();
        }
        double val = sc.nextDouble();
        sc.nextLine();
        return val;
    }

    private String lerTexto(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }
}

