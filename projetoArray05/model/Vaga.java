package projetoArray05.model;

public class Vaga {
    private String cidade;
    private int experienciaMinima;
    private String[] tecnologiasRequeridas;

    public Vaga(String cidade, int experienciaMinima, String[] tecnologiasRequeridas) {
        this.cidade = cidade;
        this.experienciaMinima = experienciaMinima;
        this.tecnologiasRequeridas = tecnologiasRequeridas;
    }

    public String getCidade() { return cidade; }
    public int getExperienciaMinima() { return experienciaMinima; }
    public String[] getTecnologiasRequeridas() { return tecnologiasRequeridas; }
}

