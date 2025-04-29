package controle;

import dominio.Pessoa;
import java.util.Scanner;

public class ControlePessoas {
    private Pessoa[] pessoas;
    private Scanner scanner;

    public ControlePessoas() {
        pessoas = new Pessoa[5];
        scanner = new Scanner(System.in);
    }

    public void cadastrarPessoas() {
        System.out.println("Cadastro de 5 pessoas:");
        for (int i = 0; i < pessoas.length; i++) {
            System.out.println("\nPessoa " + (i + 1));
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Idade: ");
            int idade = scanner.nextInt();
            System.out.print("Altura (em metros): ");
            double altura = scanner.nextDouble();
            scanner.nextLine(); // Consumir a quebra de linha
            pessoas[i] = new Pessoa(nome, idade, altura);
        }
    }

    public void exibirMenu() {
        System.out.println("\nEscolha o tipo de ordenação:");
        System.out.println("1 - Ordem alfabética (nome)");
        System.out.println("2 - Ordem crescente de idade");
        System.out.println("3 - Ordem crescente de altura");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                ordenarPorNome();
                break;
            case 2:
                ordenarPorIdade();
                break;
            case 3:
                ordenarPorAltura();
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }

        listarPessoas();
    }

    private void ordenarPorNome() {
        for (int i = 0; i < pessoas.length - 1; i++) {
            for (int j = 0; j < pessoas.length - i - 1; j++) {
                if (pessoas[j].getNome().compareToIgnoreCase(pessoas[j + 1].getNome()) > 0) {
                    Pessoa temp = pessoas[j];
                    pessoas[j] = pessoas[j + 1];
                    pessoas[j + 1] = temp;
                }
            }
        }
    }

    private void ordenarPorIdade() {
        for (int i = 0; i < pessoas.length - 1; i++) {
            for (int j = 0; j < pessoas.length - i - 1; j++) {
                if (pessoas[j].getIdade() > pessoas[j + 1].getIdade()) {
                    Pessoa temp = pessoas[j];
                    pessoas[j] = pessoas[j + 1];
                    pessoas[j + 1] = temp;
                }
            }
        }
    }

    private void ordenarPorAltura() {
        for (int i = 0; i < pessoas.length - 1; i++) {
            for (int j = 0; j < pessoas.length - i - 1; j++) {
                if (pessoas[j].getAltura() > pessoas[j + 1].getAltura()) {
                    Pessoa temp = pessoas[j];
                    pessoas[j] = pessoas[j + 1];
                    pessoas[j + 1] = temp;
                }
            }
        }
    }

    private void listarPessoas() {
        System.out.println("\nLista de Pessoas:");
        for (Pessoa p : pessoas) {
            System.out.println(p); // Agora usa automaticamente o toString() da classe Pessoa
        }
    }
}
