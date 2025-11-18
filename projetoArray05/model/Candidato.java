package projetoArray05.model;

public class Candidato {
    private String nome;
    private int anosExperiencia;
    private String cidade;
    private String[] tecnologias;

    public Candidato(String nome, int anosExperiencia, String cidade, String[] tecnologias) {
        this.nome = nome;
        this.anosExperiencia = anosExperiencia;
        this.cidade = cidade;
        this.tecnologias = tecnologias;
    }

    public String getNome() { return nome; }
    public int getAnosExperiencia() { return anosExperiencia; }
    public String getCidade() { return cidade; }
    public String[] getTecnologias() { return tecnologias; }

    @Override
    public String toString() {
        return String.format("Candidato: %s | Experiência: %d anos | Cidade: %s",
                nome, anosExperiencia, cidade);
    }
}

