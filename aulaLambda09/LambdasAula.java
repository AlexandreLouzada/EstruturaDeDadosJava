package aulaLambda09;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class Aluno {
    private final String nome;
    private final String turma;
    private final double nota;
    public Aluno(String nome, String turma, double nota) {
        this.nome = nome; this.turma = turma; this.nota = nota;
    }
    public String getNome() { return nome; }
    public String getTurma() { return turma; }
    public double getNota() { return nota; }
    @Override public String toString() {
        return nome + " (" + turma + ", " + nota + ")";
    }
}

public class LambdasAula {

    public static void main(String[] args) {
        List<Aluno> alunos = Arrays.asList(
            new Aluno("Ana", "A", 8.5),
            new Aluno("Bruno", "B", 6.2),
            new Aluno("Carla", "A", 7.1),
            new Aluno("Davi", "B", 9.0),
            new Aluno("Eva", "A", 5.8)
        );

        // 1) Ordenação
        List<Aluno> porNomeSemLambda = new ArrayList<>(alunos);
        Collections.sort(porNomeSemLambda, new Comparator<Aluno>() {
            public int compare(Aluno a, Aluno b) {
                return a.getNome().compareTo(b.getNome());
            }
        });

        List<Aluno> porNomeComLambda = new ArrayList<>(alunos);
        porNomeComLambda.sort(Comparator.comparing(Aluno::getNome));

        // 2) Filtro + contagem
        long aprovadosSemLambda = 0;
        for (Aluno a : alunos) if (a.getNota() >= 7) aprovadosSemLambda++;

        long aprovadosComLambda = alunos.stream()
            .filter(a -> a.getNota() >= 7)
            .count();

        // 3) Transformação
        List<String> nomesMaiusculosSemLambda = new ArrayList<>();
        for (Aluno a : alunos) nomesMaiusculosSemLambda.add(a.getNome().toUpperCase());

        List<String> nomesMaiusculosComLambda = alunos.stream()
            .map(Aluno::getNome)
            .map(String::toUpperCase)
            .collect(Collectors.toList());

        // 4) Agrupar por turma
        Map<String, Integer> grupoSemLambda = new HashMap<>();
        for (Aluno a : alunos) {
            grupoSemLambda.put(a.getTurma(),
                grupoSemLambda.getOrDefault(a.getTurma(), 0) + 1);
        }

        Map<String, Long> grupoComLambda = alunos.stream()
            .collect(Collectors.groupingBy(Aluno::getTurma, Collectors.counting()));

        // 5) PriorityQueue: top por nota
        PriorityQueue<Aluno> pqSemLambda = new PriorityQueue<>(new Comparator<Aluno>() {
            public int compare(Aluno a, Aluno b) {
                return Double.compare(b.getNota(), a.getNota()); // maior primeiro
            }
        });
        pqSemLambda.addAll(alunos);

        PriorityQueue<Aluno> pqComLambda = new PriorityQueue<>(
            Comparator.comparingDouble(Aluno::getNota).reversed()
        );
        pqComLambda.addAll(alunos);

        // Saídas didáticas
        System.out.println("Ordenado por nome (sem lambda): " + porNomeSemLambda);
        System.out.println("Ordenado por nome (com lambda): " + porNomeComLambda);
        System.out.println("Aprovados (sem lambda): " + aprovadosSemLambda);
        System.out.println("Aprovados (com lambda): " + aprovadosComLambda);
        System.out.println("Nomes maiúsculos (sem lambda): " + nomesMaiusculosSemLambda);
        System.out.println("Nomes maiúsculos (com lambda): " + nomesMaiusculosComLambda);
        System.out.println("Agrupado por turma (sem lambda): " + grupoSemLambda);
        System.out.println("Agrupado por turma (com lambda): " + grupoComLambda);
        System.out.println("Top (PQ sem lambda): " + pqSemLambda.peek());
        System.out.println("Top (PQ com lambda): " + pqComLambda.peek());
    }
}

