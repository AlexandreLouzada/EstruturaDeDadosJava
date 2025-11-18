package projetoArray02.view;

import projetoArray02.model.Produto;
import projetoArray02.service.CatalogoService;

import java.util.Scanner;

public class MenuCatalogo {
    private Produto[] produtos;
    private CatalogoService service;
    private final Scanner sc = new Scanner(System.in);

    public void iniciar() {
        produtos = gerarProdutos();
        service = new CatalogoService(produtos);
        int op;
        do {
            menu();
            op = lerInt("Opção: ");
            executar(op);
        } while (op != 0);
    }

    private void menu() {
        System.out.println("\n===== MENU CATÁLOGO =====");
        System.out.println("1 - Buscar por nome (parcial)");
        System.out.println("2 - Filtrar por faixa de preço");
        System.out.println("3 - Ordenar por nome (A-Z)");
        System.out.println("4 - Ordenar por valor (menor → maior)");
        System.out.println("5 - Ordenar por estoque (decrescente)");
        System.out.println("6 - Listar todos os produtos");
        System.out.println("0 - Sair");
    }

    private void executar(int op) {
        switch (op) {
            case 1 -> exibir(service.buscarPorNome(lerTexto("Nome: ")));
            case 2 -> exibir(service.filtrarPorPreco(lerDouble("Mínimo: "), lerDouble("Máximo: ")));
            case 3 -> { service.ordenarPorNomeAZ(); System.out.println("Ordenado por nome."); }
            case 4 -> { service.ordenarPorPreco(); System.out.println("Ordenado por valor."); }
            case 5 -> { service.ordenarPorEstoqueDesc(); System.out.println("Ordenado por estoque."); }
            case 6 -> exibir(service.getTodos());
            case 0 -> System.out.println("Encerrando...");
            default -> System.out.println("Opção inválida!");
        }
    }

    private Produto[] gerarProdutos() {
        Produto[] p = new Produto[100];
        for (int i = 0; i < p.length; i++) {
            p[i] = new Produto(
                1000 + i,
                "Produto" + (i % 20),
                (int)(Math.random() * 100),
                Math.round((50 + Math.random() * 950) * 100.0) / 100.0
            );
        }
        return p;
    }

    private void exibir(Produto[] lista) {
        if (lista.length == 0) System.out.println("Nenhum produto encontrado.");
        else for (Produto p : lista) System.out.println(p);
    }

    private String lerTexto(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    private int lerInt(String msg) {
        System.out.print(msg);
        while (!sc.hasNextInt()) {
            System.out.print("Número inválido. " + msg);
            sc.next();
        }
        int val = sc.nextInt(); sc.nextLine();
        return val;
    }

    private double lerDouble(String msg) {
        System.out.print(msg);
        while (!sc.hasNextDouble()) {
            System.out.print("Valor inválido. " + msg);
            sc.next();
        }
        double val = sc.nextDouble(); sc.nextLine();
        return val;
    }
}

