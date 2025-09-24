package aulaLambda03;

import java.util.*;

// Programa que filtra alunos com nota >= 7 e soma as notas (arredondadas) sem usar lambdas.
// Mostra o fluxo "filtrar -> transformar -> agregar" manualmente com for/if.
public class EstatisticasSemLambda {

    static class Aluno {
        String nome;
        double nota;
        Aluno(String nome, double nota) { this.nome = nome; this.nota = nota; }
        @Override public String toString() { return nome + " (" + nota + ")"; }
    }

    public static void main(String[] args) {
        List<Aluno> alunos = Arrays.asList(
            new Aluno("Ana", 8.5),
            new Aluno("Bruno", 6.2),
            new Aluno("Carla", 7.1),
            new Aluno("Davi", 9.0),
            new Aluno("Eva", 5.8)
        );

        int somaArredondada = 0;

        // 1) Filtra manualmente (if) alunos com nota >= 7
        // 2) Transforma a nota (arredonda com Math.round) e converte para int
        // 3) Agrega somando
        for (Aluno a : alunos) {
            if (a.nota >= 7.0) {
                int arredondada = (int) Math.round(a.nota);
                somaArredondada += arredondada;
            }
        }

        System.out.println("Soma das notas arredondadas (>=7) [sem lambda]: " + somaArredondada);
    }
}

