package projetoArray04.model;

public class Paciente {
    private String nome;
    private int id;
    private int idade;
    private int tempoDeEspera; // em minutos
    private int nivelDeUrgencia; // 1 a 5 (5 = mais urgente)

    public Paciente(String nome, int id, int idade, int tempoDeEspera, int nivelDeUrgencia) {
        this.nome = nome;
        this.id = id;
        this.idade = idade;
        this.tempoDeEspera = tempoDeEspera;
        this.nivelDeUrgencia = nivelDeUrgencia;
    }

    public String getNome() { return nome; }
    public int getId() { return id; }
    public int getIdade() { return idade; }
    public int getTempoDeEspera() { return tempoDeEspera; }
    public int getNivelDeUrgencia() { return nivelDeUrgencia; }

    @Override
    public String toString() {
        return String.format("Paciente{id=%d, nome='%s', idade=%d, espera=%dmin, urgência=%d}",
                id, nome, idade, tempoDeEspera, nivelDeUrgencia);
    }
}

