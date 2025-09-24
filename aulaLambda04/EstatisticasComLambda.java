package aulaLambda04;

import java.util.*;
import java.util.stream.*;

// Mesmo problema com lambdas e Streams (pipeline declarativo).
public class EstatisticasComLambda {

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

        // stream() cria um fluxo; encadeamos operações:
        // filter   -> mantém apenas os que satisfazem a condição
        // mapToInt -> transforma cada aluno em um int (nota arredondada)
        // sum      -> agrega (soma todos os ints)
        int somaArredondada = alunos.stream()
            .filter(a -> a.nota >= 7.0)
            .mapToInt(a -> (int) Math.round(a.nota))
            .sum();

        System.out.println("Soma das notas arredondadas (>=7) [com lambda]: " + somaArredondada);
    }
}
