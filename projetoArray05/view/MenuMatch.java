package projetoArray05.view;

import projetoArray05.model.Candidato;
import projetoArray05.model.Vaga;
import projetoArray05.service.MatchService;

import java.util.Scanner;

public class MenuMatch {
    private final Scanner sc = new Scanner(System.in);

    public void iniciar() {
        System.out.println("Cadastro da vaga:");

        String cidade = lerTexto("Cidade da vaga: ");
        int experienciaMinima = lerInt("Experiência mínima (anos): ");
        String[] tecnologias = lerTexto("Tecnologias requeridas (separadas por vírgula): ").split(",");

        Vaga vaga = new Vaga(cidade, experienciaMinima, limpar(tecnologias));

        int n = lerInt("\nQuantos candidatos deseja cadastrar? ");
        Candidato[] candidatos = new Candidato[n];
        int[] pontuacoes = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("\nCadastro do candidato %d:\n", i + 1);
            String nome = lerTexto("Nome: ");
            int exp = lerInt("Anos de experiência: ");
            String cid = lerTexto("Cidade: ");
            String[] techs = lerTexto("Tecnologias (separadas por vírgula): ").split(",");

            candidatos[i] = new Candidato(nome, exp, cid, limpar(techs));
        }

        MatchService service = new MatchService();

        for (int i = 0; i < candidatos.length; i++) {
            pontuacoes[i] = service.calcularPontuacao(candidatos[i], vaga);
        }

        service.ordenarPorPontuacao(candidatos, pontuacoes);

        System.out.println("\nTop 3 candidatos compatíveis:");
        for (int i = 0; i < Math.min(3, candidatos.length); i++) {
            System.out.printf("[%d pontos] %s\n", pontuacoes[i], candidatos[i]);
        }
    }

    private String[] limpar(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].trim();
        }
        return arr;
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
}

